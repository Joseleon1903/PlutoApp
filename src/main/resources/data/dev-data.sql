--CATALOGO INSERT ERROR_EXCEPTION
INSERT INTO error_exception VALUES(1, 501, 'Duplicate Username: the username already exists.', TRUE );
INSERT INTO error_exception VALUES(2, 502, 'Password does not match the confirm password.', TRUE );
INSERT INTO error_exception VALUES(3, 503, 'Duplicate Username: the username already exists	', TRUE );

--CATALOGO INSERT EMAIL_TEMPLATE
INSERT INTO email_template VALUES(1, 'Email_new_registration','The welcome email one of the worlds leading aplication, is quite discreet. This type of email isn’t usually recommended, as there is very little hook to the message.	','Welcome thanks for your registration');
INSERT INTO email_template VALUES(2, 'Update_user_profile','Hello, we thank you for updating your profile data.	','Welcome thanks for update your profile');

--CATALOGO INSERT PRIORITY
INSERT INTO priority VALUES(1, 'LOW');
INSERT INTO priority VALUES(2, 'MEDIUM');
INSERT INTO priority VALUES(3, 'HIGH');


--DEFAULT ADMIN PROFILE INSERT
INSERT INTO profile VALUES(1, 'admin@admin.com', 'admin','admin', '809-555-5555', null);
INSERT INTO system_user VALUES(1, '$2a$10$NQCjVkhQcNkDTwMdnWWmfuQofFAdCs.jr0.cij0CPqcBybj.QMAoK', 'admin', 1);


-- project
insert into project(id, name, description, creation_date, active)values(1, 'Pluto App','Web Aplication for project management', NOW(), true );
insert into project(id, name, description, creation_date, active)values(2, 'Artemis App','Web Aplication for project management', NOW(), true );
insert into project(id, name, description, creation_date, active)values(3, 'Hosus App','Web Aplication for project management', NOW(), true );
insert into project(id, name, description, creation_date, active)values(4, 'Cannon Color Game','Mobile Game for Unity', NOW(), true );
insert into project(id, name, description, creation_date, active)values(5, 'Client tax App','Web Aplication for project management', NOW(), true );

-- iteration
insert into iteration(id, init_date, creation_date,description, end_date, name, project_iteration, active)values(1, NOW(),NOW(),'Iteration Demo',NOW(), 'Iteration Demo' ,1, true );
insert into iteration(id, init_date, creation_date,description, end_date, name, project_iteration, active)values(2, NOW(),NOW(),'Iteration Alfa',NOW(), 'Iteration Alfa' ,1, true );
insert into iteration(id, init_date, creation_date,description, end_date, name, project_iteration, active)values(3, NOW(),NOW(),'Iteration Beta',NOW(), 'Iteration Beta' ,1, true );

-- Task

insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type) values (1, NOW(), false, 1, 'example', 1, NOW(), 1, 'Example 1', 'Example tittle 1', 'Task');
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type) values (2, NOW(), false, 1, 'example', 1, NOW(), 1, 'Example 2', 'Example tittle 2', 'Task');

