create database if not exists `jukebox`;
use jukebox;
create table if not exists `song`(
`id` int,
`name` varchar(200),
`duration` varchar(40),
`albumName`varchar(200),
`artistName`varchar(50),
`genre` varchar(50));
insert into `jukebox`.`song` (`id`, `name`, `duration`, `albumName`, `artistName`, `genre`) VALUES ('1', 'all time low', '00.03.38', 'Human -Condition', 'John-Bellion', 'Indie');
insert into `jukebox`.`song` (`id`, `name`, `duration`, `albumName`, `artistName`, `genre`) VALUES ('2', 'deap thnills', '00.03.33', 'Acting', 'Sia', 'pop-Rop');
insert into `jukebox`.`song` (`id`, `name`, `duration`, `albumName`, `artistName`, `genre`) VALUES ('3', 'doser', '00:04:03', 'joy', 'Chainsmokers', 'rock');
insert into `jukebox`.`song` (`id`, `name`, `duration`, `albumName`, `artistName`, `genre`) VALUES ('4', 'Despacito', '00:04:41', 'Despacita', 'Luis-Fonsi', 'Latin-pop');
insert into `jukebox`.`song` (`id`, `name`, `duration`, `albumName`, `artistName`, `genre`) VALUES ('5', 'Hello World', '00:02:51', 'Walkerverse', 'Alan-Walker', 'Country');
