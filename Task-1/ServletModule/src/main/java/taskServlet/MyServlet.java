package taskServlet;

import Services.FileService;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private static int counter = 0;
    File tmpFile;

    public MyServlet() {
        try {
            tmpFile = new FileService().getTempFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  Integer getCounter(int num){
        try (DataInputStream dis = new DataInputStream(new FileInputStream(tmpFile))) {
            num=dis.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }

    public void writeCounter(int num){
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(tmpFile))) {
            dos.writeInt(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkUserAgent(String userAgent){
        String user = userAgent.toLowerCase();
        String browser = "";

        if (user.contains("msie")) {
            String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser = substring.split(" ")[0].replace("MSIE", "IE");
        } else if (user.contains("safari") && user.contains("version")) {
            browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0];
        } else if (user.contains("opr") || user.contains("opera")) {
            if (user.contains("opera"))
                browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0];
            else if (user.contains("opr"))
                browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).split("/")[0].replace("OPR", "Opera"));
        } else if (user.contains("edg")) {
            browser = ((userAgent.substring(userAgent.indexOf("Edg")).split(" ")[0]).split("/")[0]).replace("Edg", "Microsoft Edge");
        } else if (user.contains("chrome")) {
            browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0].split("/")[0]);
        } else if (user.contains("firefox")) {
            browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).split("/")[0];
        } else if (user.contains("rv")) {
            browser = "IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
        } else {
            browser = "Unknown, More-Info: " + userAgent;
        }
        return browser;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        counter = getCounter(counter);
        counter++;

        String userAgent = request.getHeader("User-Agent");
        String browser = checkUserAgent(userAgent);

        response.setContentType("text/html; charset=Windows-1251");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>First Servlet</title></head>");
        out.println("<body><h1> Приветствую пользователя " + browser + "</h1>");
        out.println("<h2>Request Number: " + counter + "</h2>");
        out.println("<a href=\"/task1/jsp/form.jsp\">Set user information</a>");
        out.println("</body></html>");

        writeCounter(counter);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}
