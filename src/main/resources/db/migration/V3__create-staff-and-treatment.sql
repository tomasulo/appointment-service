create table STAFF
(
    id   SERIAL NOT NULL,
    name varchar(255),
    PRIMARY KEY (id)
);

insert into STAFF(name)
values ('MFA');
insert into STAFF(name)
values ('Doctor');

create table TREATMENT
(
    id        SERIAL NOT NULL,
    reason_id int,
    staff_id  int,
    duration  varchar(255),
    PRIMARY KEY (id),
    CONSTRAINT UC_TREATMENT UNIQUE (reason_id, staff_id),
    FOREIGN KEY (reason_id) references REASONS (id),
    FOREIGN KEY (staff_id) references STAFF (id)
);

-- General Exam
insert into TREATMENT(reason_id, staff_id, duration)
VALUES ('1', '1', 'PT10M');
insert into TREATMENT(reason_id, staff_id, duration)
VALUES ('1', '2', 'PT10M');

-- Urgent Care
insert into TREATMENT(reason_id, staff_id, duration)
VALUES ('2', '2', 'PT10M');

-- COVID
insert into TREATMENT(reason_id, staff_id, duration)
VALUES ('3', '1', 'PT5M');
insert into TREATMENT(reason_id, staff_id, duration)
VALUES ('3', '2', 'PT5M');
