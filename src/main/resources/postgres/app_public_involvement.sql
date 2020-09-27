create table involvement
(
    id               bigint generated by default as identity
        constraint involvement_pkey
            primary key,
    created_at       timestamp,
    last_modified_at timestamp,
    is_agreed        boolean,
    username         varchar(255)
);

alter table involvement
    owner to admin;

INSERT INTO public.involvement (id, created_at, last_modified_at, is_agreed, username) VALUES (1, '2020-09-27 18:27:54.208000', '2020-09-27 18:28:08.633000', true, 'Robin');
INSERT INTO public.involvement (id, created_at, last_modified_at, is_agreed, username) VALUES (2, '2020-09-27 18:47:44.970000', '2020-09-27 18:47:44.970000', true, 'Yaren');