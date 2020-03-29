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


-- project
insert into project(id, name, description, creation_date, active)values(1, 'Pluto App','Web Aplication for project management', NOW(), true );
insert into project(id, name, description, creation_date, active)values(2, 'Artemis App','Web Aplication for project management', NOW(), true );
insert into project(id, name, description, creation_date, active)values(3, 'Hosus App','Web Aplication for project management', NOW(), true );
insert into project(id, name, description, creation_date, active)values(4, 'Cannon Color Game','Mobile Game for Unity', NOW(), true );
insert into project(id, name, description, creation_date, active)values(5, 'Client tax App','Web Aplication for project management', NOW(), true );

-- iteration
insert into iteration(id, init_date, creation_date,description, end_date, name, project_iteration, active)values(1, NOW(),NOW(),'iteration Demo',NOW(), 'iteration Demo' ,1, true );
insert into iteration(id, init_date, creation_date,description, end_date, name, project_iteration, active)values(2, NOW(),NOW(),'iteration Alfa',NOW(), 'iteration Alfa' ,1, true );
insert into iteration(id, init_date, creation_date,description, end_date, name, project_iteration, active)values(3, NOW(),NOW(),'iteration Beta',NOW(), 'iteration Beta' ,1, true );

-- Task

insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (1, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 1', 'Example tittle 1', 'Task', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (2, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 2', 'Example tittle 2', 'Task', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (3, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 3', 'Example tittle 3', 'Enhancement', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (4, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 4', 'Example tittle 4', 'Enhancement', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (5, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 5', 'Example tittle 5', 'Enhancement', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (6, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 6', 'Example tittle 6', 'Issue', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (7, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 7', 'Example tittle 7', 'Issue', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (8, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 8', 'Example tittle 8', 'Task', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (9, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 9', 'Example tittle 9', 'Task', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (10, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 10', 'Example tittle 10', 'Bug', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (11, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 11', 'Example tittle 11', 'Bug', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (12, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 22', 'Example tittle 12', 'Bug', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (13, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 13', 'Example tittle 13', 'Task', 2);
insert into task (id, end_date, is_done, iteration_task, note, priority_id, start_date, status, task_detail, task_tittle, type, statement_id) values (14, NOW(), false, 1, 'example', 1, NOW(), 50, 'Example 14', 'Example tittle 14', 'Issue', 2);


