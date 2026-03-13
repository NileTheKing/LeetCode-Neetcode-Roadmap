with stable_days as (
    select user_id, action_date, action
    from activity
    group by user_id, action_date
    having count(*) = 1
),
streak as (
    select user_id, action, count(*) as streak_length,
    min(action_date) as start_date,
    max(action_date) as end_date
    from (
        select *, 
        date_sub(action_date, interval row_number() over (partition by user_id, action order by action_date) day) as grp
        from stable_days
    ) as t
    group by user_id, action
)

select user_id, action, streak_length, start_date, end_date
from (
    select *, rank() over (partition by user_id order by streak_length desc) as rnk
    from streak
    where streak_length >= 5
) as t
where rnk = 1
order by streak_length desc, user_id asc;