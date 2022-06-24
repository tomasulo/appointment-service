CREATE TABLE REASONS
(
    id SERIAL NOT NULL,
    title varchar(255),
    description varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE APPOINTMENTS
(
    id SERIAL NOT NULL,
    channel varchar(255),
    notes varchar(255),
    symptoms varchar(255),
    video_call_link varchar(255),
    cancellation_link varchar(255),
    start_time timestamp with time zone,
    end_time timestamp with time zone,
    patient_id varchar(255),
    practice_id varchar(255),
    staff_id varchar(255),
    reason_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (reason_id) references REASONS(id)
);
