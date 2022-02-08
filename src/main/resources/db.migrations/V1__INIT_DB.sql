Hibernate: drop table if exists coin cascade
Hibernate: drop table if exists transaction cascade
Hibernate: drop table if exists transaction_route cascade
Hibernate: create table coin (id  bigserial not null, sym varchar(255), primary key (id))
Hibernate: create table transaction (id int8 not null, coin_amount int8, price_usd int8, coin_id int8 not null, route_id int8 not null, primary key (id))
Hibernate: create table transaction_route (id  bigserial not null, from_place varchar(255), to_place varchar(255), primary key (id))
Hibernate: alter table transaction add constraint FKat4g6dy8mpmokjxbacicuw9qs foreign key (coin_id) references coin
Hibernate: alter table transaction add constraint FKjt1hwqrwf8og9f19fqsnl179i foreign key (route_id) references transaction_route