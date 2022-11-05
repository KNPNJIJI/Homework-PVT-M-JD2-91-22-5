<!DOCTYPE html>
<html>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous"
  />
  <h1>Set user information</h1>
  <div class="container text-center">
    <div class="row justify-content-center">
      <div class="col align-self-center card col-sm-4">
        <div class="card-body">
          <form
            action="/task1/SetUser.do"
            method="post"
            onsubmit="onSubmit(event)"
          >
            <label class="form-label" for="name">Name:</label>
            <input
              class="form-control"
              type="text"
              id="name"
              name="name"
              required
            />
            <label class="form-label" for="phone"
              >Enter your phone number:</label
            >
            <input
              class="form-control"
              type="tel"
              id="phone"
              name="phone"
              placeholder="8012-345-67-890"
              pattern="[0-9]{4}-[0-9]{3}-[0-9]{2}-[0-9]{2}"
            />
            <label class="form-label" for="email">Enter your email:</label>
            <input class="form-control" type="email" id="email" name="email" />
            <span id="error"></span><br />

            <input
              type="submit"
              id="sname"
              name="sname"
              value="Go!"
              class="btn btn-primary"
            />
          </form>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript">
    const error = document.getElementById("error");

    function onSubmit(event) {
      const email = document.getElementById("email").value;
      const phone = document.getElementById("phone").value;

      if (email == "" && phone == "") {
        error.textContent = "Please enter a valid phone or email";
        error.style.color = "red";
        event.preventDefault();
      } else {
        error.textContent = "";
      }
    }
  </script>
</html>
