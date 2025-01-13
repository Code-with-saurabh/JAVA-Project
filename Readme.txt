createTable query :-
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique user identifier
    username VARCHAR(255) NOT NULL UNIQUE,    -- Username for login
    password VARCHAR(255) NOT NULL,           -- Password for authentication
    email VARCHAR(255),                       -- User's email address
    phone VARCHAR(20),                        -- User's phone number
    firstname VARCHAR(100),                   -- User's first name
    lastname VARCHAR(100),                    -- User's last name
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- When the user was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- When the user was last updated
);

