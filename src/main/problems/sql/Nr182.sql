SELECT DISTINCT Email
FROM Person p1
WHERE Email IN (SELECT Email From Person p2 Where p1.Id != p2.Id)
