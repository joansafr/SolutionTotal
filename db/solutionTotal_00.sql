
CREATE TABLE ST_Alumno
(
	CodigoAlumno         INTEGER AUTO_INCREMENT,
	NombreAlumno         VARCHAR(50) NOT NULL,
	ApellidoPaternoAlumno VARCHAR(50) NOT NULL,
	ApellidoMaternoAlumno VARCHAR(50) NULL,
	CorreoElectronicoAlumno VARCHAR(50) NOT NULL,
	TelefonoFijoAlumno   VARCHAR(15) NOT NULL,
	TelefonoMovilAlumno  VARCHAR(15) NULL,
	PRIMARY KEY (CodigoAlumno)
  
);



CREATE TABLE ST_Asistencia
(
	CodigoAsistencia     INTEGER AUTO_INCREMENT,
	CodigoTallerAlumno   INTEGER NOT NULL,
	FechaTallerAlumno    CHAR(18) NOT NULL,
	UsuarioAuditoria     VARCHAR(20) NULL,
	PRIMARY KEY (CodigoAsistencia)
  
);



CREATE TABLE ST_Ciclo
(
	AnoCiclo             VARCHAR(4) NULL,
	NumeroCiclo          VARCHAR(2) NULL,
	FechaInicioCiclo     DATE NULL,
	CodigoCiclo          INTEGER AUTO_INCREMENT,
	FechaFinCiclo        DATE NULL,
	PRIMARY KEY (CodigoCiclo)
  
);




CREATE TABLE ST_Curso
(
	CodigoCurso          int AUTO_INCREMENT,
	NombreCurso          VARCHAR(50) NOT NULL,
	CodigoCursoTipo      INTEGER NULL,
	MaximaCantidadHorasCurso INTEGER NOT NULL,
	PRIMARY KEY (CodigoCurso)
  
);



CREATE TABLE ST_CursoTipo
(
	CodigoCursoTipo      INTEGER AUTO_INCREMENT,
	NombreCursoTipo      VARCHAR(50) NOT NULL,
	PRIMARY KEY (CodigoCursoTipo)
  
);


CREATE TABLE ST_FormaPago
(
	CodigoFormaPago      INTEGER AUTO_INCREMENT,
	DescripcionFormaPago VARCHAR(50) NOT NULL,
	InteresFormaPago     DECIMAL(9,2) NOT NULL,
	PRIMARY KEY (CodigoFormaPago)
  
);



CREATE TABLE ST_Laboratorio
(
	CodigoLaboratorio    INTEGER AUTO_INCREMENT,
	PabellonLaboratorio  VARCHAR(2) NULL,
	PisoLaboratorio      INTEGER NULL,
	NumeroLaboratorio    INTEGER NULL,
	MaximaCapacidadLaboratorio INTEGER NOT NULL,
	PRIMARY KEY (CodigoLaboratorio)
  
);


CREATE TABLE ST_Nota
(
	CodigoNota           INTEGER AUTO_INCREMENT,
	CodigoTallerAlumno   INTEGER NOT NULL,
	Nota                 INTEGER NOT NULL,
	PRIMARY KEY (CodigoNota)
  
);



CREATE TABLE ST_Pago
(
	CodigoPago           INTEGER AUTO_INCREMENT,
	MontoPago            DECIMAL(9,2) NOT NULL,
	CodigoTallerAlumno   INTEGER NOT NULL,
	PRIMARY KEY (CodigoPago)
  
);



CREATE TABLE ST_Taller
(
	CodigoTaller         INTEGER AUTO_INCREMENT,
	CodigoCurso          int NOT NULL,
	CantidadHorasTaller  INTEGER NOT NULL,
	CodigoCiclo          INTEGER NOT NULL,
	PrecioTaller         DECIMAL(9,2) NOT NULL,
	PRIMARY KEY (CodigoTaller)
  
);




CREATE TABLE ST_TallerAlumno
(
	CodigoTallerAlumno   INTEGER AUTO_INCREMENT,
	CodigoAlumno         INTEGER NOT NULL,
	CodigoTaller         INTEGER NOT NULL,
	CodigoFormaPago      INTEGER NOT NULL,
	PRIMARY KEY (CodigoTallerAlumno)
);


CREATE TABLE ST_TallerLaboratorio
(
	CodigoTallerLaboratorio INTEGER AUTO_INCREMENT,
	CodigoTaller         INTEGER NOT NULL,
	CodigoLaboratorio    INTEGER NOT NULL,
	FechaTallerLaboratorio DATE NOT NULL,
	HoraInicioTallerLaboratorio TIME NOT NULL,
	HoraTerminoTallerLaboratorio TIME NOT NULL,
	PRIMARY KEY (CodigoTallerLaboratorio)
  
);

CREATE TABLE ST_Usuario
(
	CodigoUsuario        INTEGER AUTO_INCREMENT,
	NombreUsuario        VARCHAR(50) NOT NULL,
	CodigoUsuarioTipo    INTEGER NOT NULL,
	ApellidoPaternoUsuario VARCHAR(50) NOT NULL,
	ApellidoMaternoUsuario VARCHAR(50) NULL,
	CorreoElectronicoUsuario VARCHAR(50) NOT NULL,
	TelefonoFijoUsuario  VARCHAR(15) NOT NULL,
	TelefonoMovilUsuario VARCHAR(15) NULL,
	IdentificadorUsuario VARCHAR(20) NOT NULL,
	ContrasenaUsuario    VARCHAR(20) NOT NULL,
	PRIMARY KEY (CodigoUsuario)
  
);

CREATE TABLE ST_UsuarioTipo
(
	CodigoUsuarioTipo    INTEGER AUTO_INCREMENT,
	NombreUsuarioTipo    VARCHAR(20) NOT NULL,
	PRIMARY KEY (CodigoUsuarioTipo)
  
);


ALTER TABLE ST_Asistencia
ADD FOREIGN KEY R_10 (CodigoTallerAlumno) REFERENCES ST_TallerAlumno (CodigoTallerAlumno);



ALTER TABLE ST_Curso
ADD FOREIGN KEY R_1 (CodigoCursoTipo) REFERENCES ST_CursoTipo (CodigoCursoTipo);



ALTER TABLE ST_Nota
ADD FOREIGN KEY R_11 (CodigoTallerAlumno) REFERENCES ST_TallerAlumno (CodigoTallerAlumno);



ALTER TABLE ST_Pago
ADD FOREIGN KEY R_13 (CodigoTallerAlumno) REFERENCES ST_TallerAlumno (CodigoTallerAlumno);



ALTER TABLE ST_Taller
ADD FOREIGN KEY R_3 (CodigoCiclo) REFERENCES ST_Ciclo (CodigoCiclo);



ALTER TABLE ST_Taller
ADD FOREIGN KEY R_4 (CodigoCurso) REFERENCES ST_Curso (CodigoCurso);



ALTER TABLE ST_TallerAlumno
ADD FOREIGN KEY R_8 (CodigoAlumno) REFERENCES ST_Alumno (CodigoAlumno);



ALTER TABLE ST_TallerAlumno
ADD FOREIGN KEY R_9 (CodigoTaller) REFERENCES ST_Taller (CodigoTaller);



ALTER TABLE ST_TallerAlumno
ADD FOREIGN KEY R_12 (CodigoFormaPago) REFERENCES ST_FormaPago (CodigoFormaPago);



ALTER TABLE ST_TallerLaboratorio
ADD FOREIGN KEY R_6 (CodigoTaller) REFERENCES ST_Taller (CodigoTaller);



ALTER TABLE ST_TallerLaboratorio
ADD FOREIGN KEY R_7 (CodigoLaboratorio) REFERENCES ST_Laboratorio (CodigoLaboratorio);



ALTER TABLE ST_Usuario
ADD FOREIGN KEY R_2 (CodigoUsuarioTipo) REFERENCES ST_UsuarioTipo (CodigoUsuarioTipo);


