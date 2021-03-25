DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;

CREATE TABLE users (
    id NUMERIC AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    email VARCHAR(40) NOT NULL,
    password VARCHAR(40) NOT NULL,
    birthday VARCHAR(40) NOT NULL
);
CREATE TABLE books(
    id NUMERIC AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(40) NOT NULL,
    category VARCHAR(20) NOT NULL,
    author VARCHAR(40) NOT NULL,
    publish_date VARCHAR(40) NOT NULL,
    availability VARCHAR(20) NOT NULL
);

INSERT INTO books
(id, title,category,author,publish_date,availability)
VALUES
(1, 'The Catcher in the Rye','STEM','qqqqqqq','11.12.1978','AVAILABLE'),
(2, 'Nine Stories','Economy','zzzzzz','21.10.1875','AVAILABLE'),
(3, 'Franny and Zooey','Sci-Fi','cccccc','11.12.2008','AVAILABLE'),
(4, 'The Great Gatsby','Literature','bbbb','23.12.2101','AVAILABLE'),
(5, 'Tender id the Night','Detective','aaaaaaa','10.09.2003','AVAILABLE'),
(6, 'Pride and Prejudice','History','hhhhhhh','1.02.2245','AVAILABLE')
;