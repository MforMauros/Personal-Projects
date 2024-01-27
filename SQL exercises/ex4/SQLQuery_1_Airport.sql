-- 1
SELECT * 
    FROM flights
WHERE depDate = '2018-05-01' AND toCity = 'Τορόντο';

-- 2
SELECT *
    FROM flights
WHERE distance BETWEEN 900 AND 1500
ORDER BY distance;

-- 3
SELECT toCity, COUNT(fno) 
    FROM flights
WHERE depDate BETWEEN '2018-05-01' AND '2018-05-30'
GROUP BY toCity;

-- 4
SELECT toCity, COUNT(fno) AS numberOfFlights
    FROM flights
GROUP BY toCity
HAVING COUNT(fno) >= 3;

-- 5
SELECT firstname, lastname, c.empid, COUNT(aid)
    FROM employees em JOIN certified c ON em.empid = c.empid
GROUP BY c.empid, em.firstname, em.lastname
HAVING COUNT(aid) >= 3;

-- 6
SELECT SUM(salary)
    FROM employees;

-- 7
SELECT SUM(salary)
    FROM employees
WHERE empid IN (SELECT c.empid FROM certified c);

-- 8
SELECT SUM(salary)
    FROM employees
WHERE empid NOT IN (SELECT c.empid FROM certified c);

-- 9
SELECT aname 
    FROM aircrafts 
WHERE crange > (SELECT distance FROM flights
                WHERE fromCity = 'Αθήνα' and toCity = 'Μελβούρνη');

-- 10
SELECT aname, firstname, lastname
    FROM employees em JOIN certified c ON em.empid = c.empid
                      JOIN aircrafts a ON c.aid = a.aid
WHERE aname LIKE 'Boeing%';

-- 11
SELECT aname, firstname, lastname
    FROM employees em JOIN certified c ON em.empid = c.empid
                      JOIN aircrafts a ON c.aid = a.aid
WHERE aname NOT LIKE 'Boeing%' AND crange > 3000;

-- 12
SELECT firstname, lastname
    FROM employees
WHERE salary = ( SELECT MAX(salary) FROM employees);

-- 13
select  lastname, firstname, salary
 from employees 
 where salary= (select max(salary) from employees 
                  where salary < (SELECT max (salary) from employees));

-- 14
SELECT aname
    FROM aircrafts a JOIN certified c ON a.aid = c.aid
                      JOIN employees em ON c.empid = em.empid
WHERE salary >= 6000;

-- 15
SELECT c.empid, MAX(crange)
    FROM employees em JOIN certified c ON em.empid = c.empid
                      JOIN aircrafts a ON c.aid = a.aid 
GROUP BY c.empid
HAVING COUNT(c.aid) >= 3 ;

-- 16
SELECT lastname, firstname
    FROM employees
WHERE salary < (SELECT MIN(price) FROM flights WHERE toCity = 'Μελβούρνη');

-- 17
SELECT e.lastname, e.firstname, e.salary
    FROM employees e
WHERE e.empid NOT IN (SELECT c.empid FROM certified c) AND e.salary > 
(select avg(em.salary) from employees em WHERE em.empid IN (SELECT ce.empid FROM certified ce));

-- 18
CREATE VIEW pilots AS
SELECT *
    FROM employees
WHERE empid IN (SELECT c.empid FROM certified c);

CREATE VIEW others AS
SELECT *
    FROM employees
WHERE empid not IN (SELECT c.empid FROM certified c);

select sum (salary) from pilots;

select sum (salary) from others;

select * from others where salary > (select avg(salary) from pilots);

-- 19
CREATE view airplanes AS
SELECT aname, fno, fromCity, toCity
    FROM aircrafts, flights
WHERE crange > distance;

SELECT aname, COUNT(fno)
from airplanes
GROUP  BY aname;

-- 20
CREATE PROCEDURE rate_prices AS

DECLARE @price numeric
DECLARE @minfno varchar(10)

SELECT @minfno=min(fno) FROM flights

WHILE @minfno is NOT NULL
BEGIN
   SET @price= (SELECT price FROM flights WHERE flights.fno=@minfno) 
   
IF (@price is NOT NULL) 
BEGIN

  SELECT CASE
    WHEN @price<=500 THEN @minfno+': '+CAST(@price AS VARCHAR(12)) + ' Φθηνή'
    WHEN @price<=1500 THEN @minfno+': '+CAST(@price AS  VARCHAR(12)) + ' Κανονική'
    ELSE @minfno+': '+CAST(@price AS VARCHAR(12)) + ' Ακριβή'
  END
END
SELECT @minfno=min(fno) FROM flights where @minfno < fno
END


execute rate_flights


-- 21

drop procedure Pilots_certification
create procedure Pilots_Certification
@lastname varchar(30), @firstname varchar(30), @empid int, @name varchar(20), @aid int
as
declare @pilot int
declare @aircraft int
declare @certification bit
begin
	select @pilot=empid from employees where employees.empid=@empid
	select @aircraft=aid from aircrafts where aid=@aid
	begin
		if(not exists(select * from certified where empid=@empid and aid=@aid))
		begin
			if(@pilot is null) insert into employees values (@empid, @lastname, @firstname, 1)
			if(@aircraft is null) insert into aircrafts values (@aid, @name, 0)
			insert into certified values (@empid, @aid)
		end
		else
		begin
			print 'Ο πιλότος είναι ήδη πιστοποιημένος.'
		end
	end
end


-- 22

create trigger Increase_salary_of_pilots
on certified
after insert
as
begin
	declare @empid int
	set @empid = (select empid from INSERTED)
	if(3=(select count(aid) from certified where empid=@empid))
	begin
		update employees set salary= salary *1.1  where empid=@empid
	end
end

-- 23

create trigger History_of_tickets
on flights
after update
as if update(price)
begin
	declare @fno varchar(5)
	select @fno = (select fno from deleted)
	declare @price_old int
	select @price_old = (select price from deleted)
	declare @price_new int
	select @price_new = (select price from inserted)
	insert into flight_history values(@fno, user_name(), getdate(), @price_old, @price_new)
end