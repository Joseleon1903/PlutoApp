--CATALOGO INSERT ERROR_EXCEPTION
INSERT INTO error_exception VALUES(1, 501, 'Duplicate Username: the username already exists.', TRUE );
INSERT INTO error_exception VALUES(2, 502, 'Password does not match the confirm password.', TRUE );
INSERT INTO error_exception VALUES(3, 503, 'Duplicate Username: the username already exists	', TRUE );
INSERT INTO error_exception VALUES(4, 504, 'Invalid input form: there are required data not provided', TRUE );
INSERT INTO error_exception VALUES(5, 505, 'Duplicate project name: the project name already exists	', TRUE );
INSERT INTO error_exception VALUES(6, 506, 'Project not found: name project not found in database', TRUE );
INSERT INTO error_exception VALUES(7, 507, 'Iteration not found: name Iteration not found in database', TRUE );
INSERT INTO error_exception VALUES(8, 500, 'Internal server error: internal service error, contact system administrator', TRUE );


--CATALOGO INSERT EMAIL_TEMPLATE
INSERT INTO email_template VALUES(1, 'Email_new_registration','The welcome email one of the worlds leading aplication, is quite discreet. This type of email isn’t usually recommended, as there is very little hook to the message.	','Welcome thanks for your registration');
INSERT INTO email_template VALUES(2, 'Update_user_profile','Hello, we thank you for updating your profile data.	','Welcome thanks for update your profile');

--CATALOGO INSERT PRIORITY
INSERT INTO priority VALUES(1, 'LOW');
INSERT INTO priority VALUES(2, 'MEDIUM');
INSERT INTO priority VALUES(3, 'HIGH');

--CATALOGO INSERT STATEMENT
INSERT INTO statement VALUES(1, 'In Progres');
INSERT INTO statement VALUES(2, 'New');
INSERT INTO statement VALUES(3, 'Active');
INSERT INTO statement VALUES(4, 'Stop');
INSERT INTO statement VALUES(5, 'Closed');

--DEFAULT ADMIN PROFILE INSERT
INSERT INTO profile VALUES(1, 'admin@admin.com', 'admin','admin', '809-555-5555', null);
INSERT INTO system_user VALUES(1, '$2a$10$NQCjVkhQcNkDTwMdnWWmfuQofFAdCs.jr0.cij0CPqcBybj.QMAoK', 'admin', 1);
