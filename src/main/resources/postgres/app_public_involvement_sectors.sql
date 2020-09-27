create table involvement_sectors
(
    involvement_id bigint not null
        constraint fk6nxpd7krseporrgi6d7f3weaw
            references involvement,
    sectors_id     bigint not null
        constraint fkioynlxv3grm0v5t2f2j1f5gy5
            references sector
);

alter table involvement_sectors
    owner to admin;

INSERT INTO public.involvement_sectors (involvement_id, sectors_id) VALUES (1, 6);
INSERT INTO public.involvement_sectors (involvement_id, sectors_id) VALUES (2, 5);
INSERT INTO public.involvement_sectors (involvement_id, sectors_id) VALUES (2, 15);