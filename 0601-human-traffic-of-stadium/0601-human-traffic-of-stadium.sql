# Write your MySQL query statement below
select id, visit_date, people
from (
    select id, visit_date, people,
        count(*) over (partition by grp) as cnt
    from (
        select id, visit_date, people, (id - row_number() over (order by id asc)) as grp
        from stadium
        where people >= 100
    ) as T
)as result
where cnt >= 3
order by visit_date;