create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );

create table user_role (user_id bigint not null, roles varchar(255));
create table usrs (id bigint not null AUTO_INCREMENT, activation_code varchar(255), active bit not null, email varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id));



alter table user_role add constraint FKj6q10q8158i3jfoeilrjlee6k foreign key (user_id) references usrs (id);




CREATE TABLE `client` (  `id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,`name` varchar(254) NOT NULL,`last_name` varchar(256) NOT NULL,`middle_name` varchar(254) NOT NULL,`phone` varchar(254) NOT NULL,`email` varchar(256) NOT NULL);

INSERT INTO `client` (`id`, `name`, `last_name`, `middle_name`, `phone`, `email`) VALUES (1, 'dfsdfsdf', 'qweqweqwe', 'acsadqwd', '132123123', 'asdasdasdasd');

CREATE TABLE `developer` (`id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,`name` varchar(256) NOT NULL,`last_name` varchar(256) NOT NULL,`middle_name` varchar(256) NOT NULL,`email` varchar(256) NOT NULL,`phone` varchar(256) NOT NULL,`status` tinyint(1) NOT NULL);

INSERT INTO `developer` (`id`, `name`, `last_name`, `middle_name`, `email`, `phone`, `status`) VALUES
(1, 'qwe', 'req', '1ew', 'asdasd', '123123', 1);

CREATE TABLE `orderr` (`id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,`name` varchar(256) NOT NULL,`description` varchar(256) NOT NULL,`status` tinyint(1) NOT NULL);

INSERT INTO `orderr` (`id`, `name`, `description`, `status`) VALUES (1, 'gtgtgtg', 'erwersdfdsf', 1);

CREATE TABLE `orders` (`id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,`date` date NOT NULL,`client_id` int(11) NOT NULL,INDEX `client_id` (`client_id`),`developer_id` int(11) NOT NULL,INDEX `developer_id` (`developer_id`),`order_id` int(11) NOT NULL,INDEX `order_id` (`order_id`));

INSERT INTO `orders` (`id`, `date`, `client_id`, `developer_id`, `order_id`) VALUES (1, '2018-10-01', 1, 1, 1);

CREATE TABLE `profile` (`id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,`name` varchar(256) DEFAULT NULL,`description` varchar(256) DEFAULT NULL);

INSERT INTO `profile` (`id`, `name`, `description`) VALUES (1, 'asdasd', 'asdasdasdasd');

CREATE TABLE `profiles` (`id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,`developer_id` int(11) NOT NULL,INDEX `developer_id` (`developer_id`),`profile_id` int(11) NOT NULL,INDEX `profile_id` (`profile_id`));

INSERT INTO `profiles` (`id`, `developer_id`, `profile_id`) VALUES (1, 1, 1);


ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`developer_id`) REFERENCES `developer` (`id`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `orderr` (`id`);

ALTER TABLE `profiles`
  ADD CONSTRAINT `profiles_ibfk_1` FOREIGN KEY (`developer_id`) REFERENCES `developer` (`id`),
  ADD CONSTRAINT `profiles_ibfk_2` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);
COMMIT;