DELETE
FROM Person
WHERE id NOT IN (
    SELECT min(id)
    FROM (SELECT * FROM Person) person_cpy
    GROUP BY EMAIL
);