CREATE TABLE cliente (

clienteid serial,

clienteactivo bool NOT NULL,

clientenombre varchar NOT NULL,

clientefechacreacion timestamptz(3) NOT NULL DEFAULT now(),

clientefechamodificacion timestamptz(3) NOT NULL DEFAULT now(),

CONSTRAINT cliente_pkey PRIMARY KEY (clienteid)

);

 

CREATE TABLE consignatario (

clienteid int4 NOT NULL,

consignatarioid int4 NOT NULL,

consignatarioactivo bool NOT NULL,

consignatarionombre varchar NOT NULL,

consignatariofechacreacion timestamptz(3) NOT NULL DEFAULT now(),

consignatariofechamodificacion timestamptz(3) NOT NULL DEFAULT now(),

CONSTRAINT consignatario_pkey PRIMARY KEY (clienteid, consignatarioid),

constraint consignatario_clienteid_fk FOREIGN KEY (clienteid) REFERENCES cliente(clienteid)

);

CREATE OR REPLACE FUNCTION consultar_cliente_consignatario()
RETURNS TABLE (clienteid integer, clientenombre character varying, clienteactivo boolean, clientefechacreacion date, clientefechamodificacion date, consignatarionombre character varying, consignatarioid integer, consignatariofechacreacion date, consignatariofechamodificacion date)
AS $$
BEGIN
RETURN QUERY
SELECT cliente.clienteid, cliente.clientenombre, cliente.clienteactivo, cliente.clientefechacreacion, cliente.clientefechamodificacion, consignatario.consignatarionombre, consignatario.consignatarioid,consignatario.consignatarioactivo, consignatario.consignatariofechacreacion, consignatario.consignatariofechamodificacion
FROM cliente
JOIN consignatario ON cliente.clienteid = consignatario.clienteid;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE actualizar_cliente_consignatario (
  clienteid INT, 
  clientenombre VARCHAR(50), 
  clienteactivo BOOLEAN, 
  clientefechacreacion DATE, 
  clientefechamodificacion DATE, 
  consignatarionombre VARCHAR(50), 
  consignatarioid INT, 
  consignatarioactivo BOOLEAN,
  consignatariofechacreacion DATE, 
  consignatariofechamodificacion DATE
) 
AS $$ 
BEGIN 
  UPDATE cliente 
  SET clientenombre = clientenombre, 
      clienteactivo = clienteactivo, 
      clientefechacreacion = clientefechacreacion, 
      clientefechamodificacion = clientefechamodificacion 
  WHERE clienteid = clienteid; 
  
  UPDATE consignatario 
  SET consignatarionombre = consignatarionombre, 
      consignatariofechacreacion = consignatariofechacreacion, 
      consignatariofechamodificacion = consignatariofechamodificacion,
	  consignatarioactivo=consignatarioactivo
  WHERE consignatarioid = consignatarioid 
  AND clienteid = clienteid; 
END; $$ 
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION agregar_cliente_consignatario()
RETURNS VOID AS $$
DECLARE
  v_clienteid INTEGER;
  v_clientenombre VARCHAR(100);
  v_clienteactivo BOOLEAN;
  v_clientefechacreacion DATE;
  v_clientefechamodificacion DATE;
  v_consignatarionombre VARCHAR(100);
  v_consignatariofechacreacion DATE;
  v_consignatariofechamodificacion DATE;
  v_consignatarioactivo BOOLEAN;
BEGIN
  INSERT INTO cliente(clienteid, clientenombre, clienteactivo, clientefechacreacion, clientefechamodificacion)
  VALUES (v_clienteid, v_clientenombre, v_clienteactivo, v_clientefechacreacion, v_clientefechamodificacion);
  
  INSERT INTO consignatario(consignatarionombre, consignatarioid, consignatariofechacreacion, consignatariofechamodificacion,consignatarioactivo, clienteid)
  VALUES (v_consignatarionombre, v_clienteid, v_consignatariofechacreacion, v_consignatariofechamodificacion,V_consignatarioactivo, v_clienteid);
END;
$$ LANGUAGE plpgsql;