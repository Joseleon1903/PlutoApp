--CATALOGO INSERT ERROR_EXCEPTION
INSERT INTO ERROR_EXCEPTION VALUES(1, 501, 'Duplicate Username: the username already exists.', TRUE );
INSERT INTO ERROR_EXCEPTION VALUES(2, 502, 'Password does not match the confirm password.', TRUE );
INSERT INTO ERROR_EXCEPTION VALUES(3, 503, 'Duplicate Username: the username already exists	', TRUE );

--CATALOGO INSERT EMAIL_TEMPLATE
INSERT INTO EMAIL_TEMPLATE VALUES(1, 'Email_new_registration','The welcome email one of the worlds leading aplication, is quite discreet. This type of email isn’t usually recommended, as there is very little hook to the message.	','Welcome thanks for your registration');
INSERT INTO EMAIL_TEMPLATE VALUES(1, 'Update_user_profile','Hello, we thank you for updating your profile data.	','Welcome thanks for update your profile');

--CATALOGO INSERT PRIORITY
INSERT INTO PRIORITY VALUES(1, LOW);
INSERT INTO PRIORITY VALUES(1, MEDIUM);
INSERT INTO PRIORITY VALUES(1, HIGH);


--DEFAULT ADMIN PROFILE INSERT
INSERT INTO PROFILE VALUES(1, 'admin@admin.com', 'admin','admin', '809-555-5555', null);
INSERT INTO USER VALUES(1, '$2a$10$NQCjVkhQcNkDTwMdnWWmfuQofFAdCs.jr0.cij0CPqcBybj.QMAoK', 'ADMIN', 1);
