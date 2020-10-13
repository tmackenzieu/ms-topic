insert into purchase_header_order values (135678490,TO_DATE('26-09-2020', 'DD-MM-YYYY'), TO_DATE('27-09-2020', 'DD-MM-YYYY'),1,'09:00 - 21:00');
insert into purchase_header_order values (135678491,TO_DATE('27-09-2020', 'DD-MM-YYYY'), TO_DATE('28-09-2020', 'DD-MM-YYYY'),1,'09:00 - 21:00');
insert into purchase_header_order values (135678492,TO_DATE('29-09-2020', 'DD-MM-YYYY'), TO_DATE('30-09-2020', 'DD-MM-YYYY'),1,'09:00 - 21:00');
insert into purchase_header_order values (135678493,TO_DATE('01-10-2020', 'DD-MM-YYYY'), TO_DATE('02-10-2020', 'DD-MM-YYYY'),1,'09:00 - 21:00');

insert into purchase_detail_order values (1,135678490,'1009796','JUEGO CARCASSONE BASICO');
insert into purchase_detail_order values (2,135678490,'87342X','JUEGO DE MESA LIBELLUD DIXIT CLASSIC');
insert into purchase_detail_order values (3,135678490,'302512','JUEGO HASBRO GAMING RISK');


insert into purchase_detail_order values (4,135678491,'1001884','Monopoly');
insert into purchase_detail_order values (5,135678491,'1001892','Clue');
insert into purchase_detail_order values (6,135678491,'100297X','Hippos Glotones');

insert into purchase_detail_order values (7,135678492,'100610X','Mala Leche con Plátano');
insert into purchase_detail_order values (8,135678492,'1006878','Mala Leche Original');
insert into purchase_detail_order values (9,135678492,'1007769','Munchkin');

insert into purchase_detail_order values (10,135678493,'1008323','Catan');
insert into purchase_detail_order values (11,135678493,'1010247','Catan Extensión 5-6 Jugadores');
insert into purchase_detail_order values (12,135678493,'101045X','Escape Tales');

insert into status_order values (1, 'Packing');
insert into status_order values (2, 'On route');
insert into status_order values (3, 'Delivered');
insert into status_order values (4, 'Pending');