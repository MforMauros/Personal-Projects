
DROP INDEX pyear_idx ON movies;
checkpoint
dbcc dropcleanbuffers


 -- 1a Στο πρώτο και το δευτερο index χρησιμοποιουμε το συγκεκριμένο index γιατι φιλτραρουμε μονο με το pyear ενω στο τρίτο επειδη εχει order by χρεαζόμαστε 
--  το pyear και το title χρησιμοποιούμε index και στα δύο.
create index pyear_idx on movies(pyear);
select title from movies where pyear between 1995 and 2005

-- 1b
create index pyear_idx on movies(pyear);
select pyear, title from movies where pyear between 1995 and 2005

-- 1c
create index pyear_idx on movies(pyear, title);
select title, pyear from movies where pyear between 1995 and 2005 order by pyear, title

-- 2a Εφόσον αυτα τα id's που θα θελαμε να κανουμε είναι PK εχουν φτιαξει clustered index με τη δημιουργία τους,
-- γι αυτό κάνουμε index μόνο στο ζητούμενο.
CREATE INDEX idx_directors_did ON directors(lastname);

SELECT title, pyear
    FROM movies m, movie_directors md, directors d
WHERE m.mid = md.mid AND md.did = d.did AND lastname = 'Zygadlo'

-- 2b
CREATE INDEX idx_movies_mid ON movies(mrank);
CREATE INDEX idx_movie_genre ON movies_genre(genre);

SELECT title, pyear, mrank
    FROM movies m, movies_genre mcat
WHERE m.mid = mcat.mid and genre = 'Comedy' and mrank > 7;

-- 2c
CREATE index idx_pyear on movies(pyear, mrank);

SELECT distinct title, mrank
    FROM movies 
WHERE pyear = 2000 and mrank >5;

-- 3.1
CREATE INDEX idx_male on actors(gender);

SELECT distinct m.title
    FROM movies m
JOIN roles r ON m.mid = r.mid
JOIN actors a ON a.aid = r.aid where gender = 'M';

-- 3.2

SELECT m.title
    from movies m, roles r, actors a
WHERE m.mid = r.mid and a.aid = r.aid and gender = 'M';



--4.1 φέρε όλες τους τίτλους απο τις ταινίες που είναι κατηγορίας Documentary και παίζουν άντρες ηθοποιοί
CREATE INDEX idx_gender_genre on actors(gender);
CREATE INDEX idx_gender_genre on movies_genre(genre);

SELECT distinct m.title
    FROM movies m
JOIN movies_genre mg ON m.mid = mg.mid 
JOIN roles r ON mg.mid = r.mid
JOIN actors a ON a.aid = r.aid where gender = 'M' and genre = 'Documentary';


--4.2 φέρε όλες τους τίτλους απο τις ταινίες που βγήκαν μετά το 2000 και έχουν rank πάνω απο 7 και παίζουν μόνο γυναίκες
CREATE INDEX idx_actors on actors(gender);
CREATE INDEX idx_movies on movies(pyear, mrank);

SELECT distinct m.title, pyear, mrank
    FROM movies m
JOIN roles r ON m.mid = r.mid
JOIN actors a ON a.aid = r.aid where gender = 'F' and pyear > 2000 and mrank > 7;

DROP INDEX idx_male ON actors;
checkpoint
dbcc dropcleanbuffers
