-- 1
SELECT lname, fname 
    FROM actors
    WHERE lname LIKE 'Κ%'
ORDER BY lname;

-- 2
SELECT title, pyear
    FROM movies
    WHERE pyear BETWEEN 1990 AND 2007
ORDER BY pyear DESC;

-- 3
SELECT title, lname, fname
    FROM movies, directors
WHERE movies.did = directors.did AND pcountry = 'GRC'
ORDER BY directors.lname;

-- 4
SELECT title, pyear
    FROM movies, directors
WHERE movies.did = directors.did AND lname = 'Σακελλάριος';

-- 5
SELECT title, pyear
    FROM movies, movie_actor,  actors
WHERE movies.mid = movie_actor.mid AND
      movie_actor.actid = actors.actid AND
      actors.lname = 'Eastwood';  

--   6
SELECT lname, fname
    FROM movies, movie_actor, actors
WHERE movies.mid = movie_actor.mid AND
      movie_actor.actid = actors.actid AND
      movies.title = 'Amelie';

-- 7
SELECT COUNT(DISTINCT copies.mid) AS dvd_copies
    FROM copies
WHERE cmedium = 'DVD';

-- 8
SELECT COUNT(copies.barcode) sum_dvd
    FROM copies
    WHERE cmedium = 'DVD';

-- 9
SELECT MAX(price)
    FROM copies
WHERE cmedium = 'DVD';

-- 10
SELECT SUM(price)
    FROM copies
WHERE cmedium = 'BLU RAY';

-- 11
SELECT lname, fname, COUNT(movies.mid) AS total_movies
    FROM directors, movies
WHERE directors.did = movies.did;

-- 12
SELECT lname, fname, COUNT(movies.mid)
    FROM movies, movie_actor, actors
WHERE movies.mid = movie_actor.mid AND 
      movie_actor.actid = actors.actid AND 
      lname = 'Παπαγιαννόπουλος'
      GROUP BY lname, fname;

-- 13
SELECT lname, fname
    FROM movies, movie_actor, actors
WHERE movies.mid = movie_actor.mid AND 
      movie_actor.actid = actors.actid AND 
      pcountry != 'GRC';
    
-- 14
SELECT title
    FROM movies, movie_actor, actors
WHERE movies.mid = movie_actor.mid AND 
      movie_actor.actid = actors.actid AND 
      lname = 'Κούρκουλος'

INTERSECT

SELECT title
    FROM movies, movie_actor, actors
WHERE movies.mid = movie_actor.mid AND 
      movie_actor.actid = actors.actid AND 
      lname = 'Καρέζη';

-- 15
SELECT title
    FROM movies, movie_actor, actors
WHERE movies.mid = movie_actor.mid AND 
      movie_actor.actid = actors.actid AND 
      lname = 'Καρέζη'

EXCEPT

SELECT title
    FROM movies, movie_actor, actors
WHERE movies.mid = movie_actor.mid AND 
      movie_actor.actid = actors.actid AND 
      lname = 'Κούρκουλος';

-- 16
SELECT title
    FROM movies, movie_cat, categories
WHERE movies.mid = movie_cat.mid AND 
      movie_cat.catid = categories.catid AND 
      category = 'Κωμωδία'

INTERSECT

SELECT title
    FROM movies, movie_cat, categories
WHERE movies.mid = movie_cat.mid AND 
      movie_cat.catid = categories.catid AND 
      category = 'Αισθηματική';

-- 17
SELECT category, COUNT(movies.mid)
    FROM movies, movie_cat, categories
WHERE movies.mid = movie_cat.mid AND 
      movie_cat.catid = categories.catid
GROUP BY category
HAVING COUNT(movies.mid) >= 5;

-- 18
SELECT lname, fname, COUNT(movies.mid) AS num_of_movies
    FROM directors LEFT JOIN movies 
    ON directors.did = movies.did
    GROUP BY lname, fname;

-- 19
DELETE
    FROM categories
    WHERE category = 'Βιογραφία';

-- 20
UPDATE copies
 SET price = 70.00
    WHERE barcode in (SELECT barcode
                        FROM movies, copies
                        WHERE copies.mid=movies.mid AND
                        cmedium='DVD' AND
                        title= 'Amelie');