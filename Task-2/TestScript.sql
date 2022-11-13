SELECT `id`, `pay_date`, `payment_receiver`, `amount`
FROM accounting.expenditure;

вывести сумму платежей за тот день, когда был наибольший платеж;
SELECT `pay_date`, sum(accounting.expenditure.amount) AS Sum 
FROM accounting.expenditure
WHERE `pay_date` IN (SELECT `pay_date` FROM accounting.expenditure 
			WHERE `amount` IN (SELECT MAX(`amount`) FROM accounting.expenditure)) 
group by `pay_date`;

вывести наибольший платеж за тот день, когда сумма платежей была наибольшей.
WITH SumDay AS
(
	SELECT `pay_date`, sum(amount) AS Sum1 
	FROM accounting.expenditure	
	group by `pay_date` 
), 
MaxDate AS 
(
SELECT `pay_date`, Sum1
FROM SumDay
WHERE Sum1 IN (SELECT MAX(Sum1)
				FROM SumDay) 
)
SELECT pay1.`pay_date`, MAX(`amount`) AS AmMAX  
FROM accounting.expenditure AS pay1
	JOIN MaxDate ON MaxDate.`pay_date` = pay1.`pay_date`
group by pay1.`pay_date`
	
    
WITH Sum_Day 
AS
(
	SELECT `pay_date`, sum(accounting.expenditure.amount) AS Sum 
	FROM accounting.expenditure
	group by `pay_date`
)
SELECT `pay_date`, Sum 
FROM SumDay
WHERE Sum IN (SELECT MAX(Sum)
			  FROM SumDay) 


--вывести список получателей платежей, и сумму платежей по каждому из них;
SELECT `payment_receiver`, sum(accounting.expenditure.amount) AS Sum
FROM accounting.expenditure
group by `payment_receiver`