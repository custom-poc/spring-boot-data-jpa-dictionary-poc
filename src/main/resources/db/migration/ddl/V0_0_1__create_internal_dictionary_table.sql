create table if not exists internal_dictionary
(
    id            uuid             not null
        constraint internal_dictionary_pk primary key,
    code          varchar(255),
    caption       varchar(255)     not null,
    priority      bigint default 0 not null,
    description   text,
    discriminator varchar(255)     not null,
    relation_id   uuid
        constraint internal_dictionary_relation_id_fk references internal_dictionary (id)
);
create index if not exists internal_dictionary_caption_index on internal_dictionary (caption);
create index if not exists internal_dictionary_priority_index on internal_dictionary (priority);
create index if not exists internal_dictionary_relation_id_index on internal_dictionary (relation_id);
create index if not exists internal_dictionary_discriminator_index on internal_dictionary (discriminator);
