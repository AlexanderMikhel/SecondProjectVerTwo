CREATE TABLE public.subject
(
  id serial, 
  name character varying(255),
  CONSTRAINT subject_pkey PRIMARY KEY (id)
);

CREATE TABLE public.teacher
(
  id serial,
  first_name character varying(255),
  last_name character varying(255),
  subject_id integer,
  CONSTRAINT teacher_pkey PRIMARY KEY (id),
  CONSTRAINT teacher_fkey FOREIGN KEY (subject_id)
      REFERENCES public.subject (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE public.class_unit
(
  id serial,
  teacher_id integer,
  CONSTRAINT class_unit_pkey PRIMARY KEY (id),
  CONSTRAINT class_unit_fkey FOREIGN KEY (teacher_id)
      REFERENCES public.teacher (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE public.student
(
  id serial,
  first_name character varying(255),
  last_name character varying(255),
  CONSTRAINT student_pkey PRIMARY KEY (id)
);

CREATE TABLE public.mark
(
  id serial,
  date date,
  value integer,
  student_id integer,
  subject_id integer,
  teacher_id integer,
  CONSTRAINT mark_pkey PRIMARY KEY (id),
  CONSTRAINT mark_fkey FOREIGN KEY (student_id)
      REFERENCES public.student (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT mark_fkey1 FOREIGN KEY (teacher_id)
      REFERENCES public.teacher (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT mark_fkey2 FOREIGN KEY (subject_id)
      REFERENCES public.subject (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE public.class_unit_mark
(
  classunit_id integer NOT NULL,
  marks_id integer,
  CONSTRAINT class_unit_mark_pkey PRIMARY KEY (classunit_id, marks_id),
  CONSTRAINT class_unit_mark_fkey FOREIGN KEY (classunit_id)
      REFERENCES public.class_unit (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT class_unit_mark_fkey1 FOREIGN KEY (marks_id)
      REFERENCES public.mark (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT uk_6rye87ba1joihjgwmfdrwd5av UNIQUE (marks_id)
);

CREATE TABLE public.stud_class
(
  id_class integer,
  id_student integer NOT NULL,
  CONSTRAINT stud_class_pkey PRIMARY KEY (id_student),
  CONSTRAINT stud_class_fkey FOREIGN KEY (id_student)
      REFERENCES public.student (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT stud_class_fkey1 FOREIGN KEY (id_class)
      REFERENCES public.class_unit (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);




