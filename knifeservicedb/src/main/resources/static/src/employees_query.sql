select avg(salary) as promedio, emp_no from salaries
where emp_no<10010
group by emp_no
order by promedio;

select count(salary) as total, emp_no from salaries
where emp_no<10010
group by emp_no
order by total desc;