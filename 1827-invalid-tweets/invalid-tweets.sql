-- Write your PostgreSQL query statement below
select tweet_id from tweets 
where 1 = 1
and length(content) > 15;