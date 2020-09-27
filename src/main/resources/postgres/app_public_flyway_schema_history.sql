create table flyway_schema_history
(
    installed_rank integer                 not null
        constraint flyway_schema_history_pk
            primary key,
    version        varchar(50),
    description    varchar(200)            not null,
    type           varchar(20)             not null,
    script         varchar(1000)           not null,
    checksum       integer,
    installed_by   varchar(100)            not null,
    installed_on   timestamp default now() not null,
    execution_time integer                 not null,
    success        boolean                 not null
);

alter table flyway_schema_history
    owner to admin;

create index flyway_schema_history_s_idx
    on flyway_schema_history (success);

INSERT INTO public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) VALUES (1, '1', 'add category table', 'SQL', 'V1__add_category_table.sql', 1553695, 'admin', '2020-09-27 18:26:57.348078', 4, true);
INSERT INTO public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) VALUES (2, '2', 'insert category', 'SQL', 'V2__insert_category.sql', 645755419, 'admin', '2020-09-27 18:26:57.376326', 23, true);