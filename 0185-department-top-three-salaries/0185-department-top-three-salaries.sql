# Write your MySQL query statement below
select d_name as department, e_name as Employee, Salary
from (
    select d.name as d_name, e.name as e_name, e.salary as salary,
     dense_rank() over (partition by d.id order by salary desc) as rnk
    from Employee e
    join Department d on e.departmentId = d.id
) as T
where T.rnk <= 3;
