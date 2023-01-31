drop user hr2 cascade;
create user hr2 identified by hr2 ;
grant connect, resource to hr2;

create table hr2.laborers(
    laborer_id number(2) constraint laborers_laborer_pk  primary key,
    laborer_name varchar2(12),
    laborer_hireDate date);
    
create sequence hr2.laborersSeq
    minvalue  1
    nomaxvalue
    increment by 1
    start with 1
    cache 20;