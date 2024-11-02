-- public.person definition
CREATE TABLE public.person (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	gender varchar(10) NULL,
	age int4 NULL,
	address varchar(255) NULL,
	phone varchar(15) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

-- public.client definition
CREATE TABLE public.client (
	"password" varchar(255) NOT NULL,
	status bool NOT NULL,
	CONSTRAINT client_pkey PRIMARY KEY (id)
)
INHERITS (public.person);

-- public.account definition
CREATE TABLE public.account (
	id serial4 NOT NULL,
	account_number varchar(20) NOT NULL,
	account_type varchar(50) NOT NULL,
	initial_balance numeric(15, 2) NULL,
    available_balance numeric(15, 2) NULL,
	status bool NULL,
	client_id int4 NULL,
	CONSTRAINT account_number_key UNIQUE (account_number),
	CONSTRAINT account_pkey PRIMARY KEY (id),
	CONSTRAINT account_client_id_fkey FOREIGN KEY (client_id) REFERENCES public.client(id)
);

-- public.movement definition
CREATE TABLE public.movement (
	id serial4 NOT NULL,
	"date" date NOT NULL,
	movement_type varchar(50) NOT NULL,
	value numeric(15, 2) NOT NULL,
	account_id int4 NOT NULL,
	CONSTRAINT movement_pkey PRIMARY KEY (id),
	CONSTRAINT movement_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.account(id)
);