--Creation of the table
create table CreditCard(card_number int not null,card_holder varchar(255) not null,card_pin int not null,card_expiry date not null,limit int not null);

--Setting the Primary Key
alter table CreditCard add constraint int PRIMARY KEY(card_number);

--Inserting records to the table
insert into CreditCard values(1234123412341234,'Gourav',4321,'11-02-2024',200000);
insert into CreditCard values(3456545654323453,'Levi',7865,'04-22-2024',150000);
insert into CreditCard values(7898765456789098,'Eren',4532,'08-21-2025',175000);
insert into CreditCard values(7898765456789098,'Eren',4532,'08-21-2025',175000);
insert into CreditCard values(2345676543467898,'Armin',3423,'06-23-2023',100000);
insert into CreditCard values(7865676565465453,'Mikasa',6754,'02-16-2025',300000);
insert into CreditCard values(7465787654345654,'Saitama',7645,'05-30-2024',250000);
insert into CreditCard values(6754567898789098,'John',5432,'07-27-2025',150000);
insert into CreditCard values(6754567898789098,'Madara',9870,'04-18-2023',100000);
insert into CreditCard values(6574563456434567,'Itachi',7657,'02-20-2026',200000);
insert into CreditCard values(456798907656,'Nagato',3457,'05-21-2024',150000);

--Updating expiry date for some records
update CreditCard set card_expiry='03-26-2027' where card_holder='Levi';
update CreditCard set card_expiry='06-24-2027' where card_number=7465787654345654;
