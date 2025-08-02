select a.user_id, round(sum(case when b.action ='confirmed' then 1 else 0 end)/count(*),2) as confirmation_rate from signups a left join Confirmations b on a.user_id = b.user_id group by a.user_id;

