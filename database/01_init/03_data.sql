INSERT INTO tour (id, actif, annee, cle, mois, semaine_mois) VALUES 
	(nextval('tour_id_seq'),'true',0,0,0,0),
	(nextval('tour_id_seq'),'false',0,1,0,1),
	(nextval('tour_id_seq'),'false',0,2,0,2),
	(nextval('tour_id_seq'),'false',0,3,0,3),
	(nextval('tour_id_seq'),'false',0,4,1,0),
	(nextval('tour_id_seq'),'false',0,5,1,1),
	(nextval('tour_id_seq'),'false',0,6,1,2),
	(nextval('tour_id_seq'),'false',0,7,1,3),
	(nextval('tour_id_seq'),'false',0,8,2,0),
	(nextval('tour_id_seq'),'false',0,9,2,1),
	(nextval('tour_id_seq'),'false',0,10,2,2),
	(nextval('tour_id_seq'),'false',0,11,2,3),
	(nextval('tour_id_seq'),'false',0,12,3,0),
	(nextval('tour_id_seq'),'false',0,13,3,1),
	(nextval('tour_id_seq'),'false',0,14,3,2),
	(nextval('tour_id_seq'),'false',0,15,3,3),
	(nextval('tour_id_seq'),'false',0,16,4,0),
	(nextval('tour_id_seq'),'false',0,17,4,1),
	(nextval('tour_id_seq'),'false',0,18,4,2),
	(nextval('tour_id_seq'),'false',0,19,4,3),
	(nextval('tour_id_seq'),'false',0,20,5,0),
	(nextval('tour_id_seq'),'false',0,21,5,1),
	(nextval('tour_id_seq'),'false',0,22,5,2),
	(nextval('tour_id_seq'),'false',0,23,5,3),
	(nextval('tour_id_seq'),'false',0,24,6,0),
	(nextval('tour_id_seq'),'false',0,25,6,1),
	(nextval('tour_id_seq'),'false',0,26,6,2),
	(nextval('tour_id_seq'),'false',0,27,6,3),
	(nextval('tour_id_seq'),'false',0,28,7,0),
	(nextval('tour_id_seq'),'false',0,29,7,1),
	(nextval('tour_id_seq'),'false',0,30,7,2),
	(nextval('tour_id_seq'),'false',0,31,7,3),
	(nextval('tour_id_seq'),'false',0,32,8,0),
	(nextval('tour_id_seq'),'false',0,33,8,1),
	(nextval('tour_id_seq'),'false',0,34,8,2),
	(nextval('tour_id_seq'),'false',0,35,8,3),
	(nextval('tour_id_seq'),'false',0,36,9,0),
	(nextval('tour_id_seq'),'false',0,37,9,1),
	(nextval('tour_id_seq'),'false',0,38,9,2),
	(nextval('tour_id_seq'),'false',0,39,9,3),
	(nextval('tour_id_seq'),'false',0,40,10,0),
	(nextval('tour_id_seq'),'false',0,41,10,1),
	(nextval('tour_id_seq'),'false',0,42,10,2),
	(nextval('tour_id_seq'),'false',0,43,10,3),
	(nextval('tour_id_seq'),'false',0,44,11,0),
	(nextval('tour_id_seq'),'false',0,45,11,1),
	(nextval('tour_id_seq'),'false',0,46,11,2),
	(nextval('tour_id_seq'),'false',0,47,11,3);
	
INSERT INTO competence (id, libelle, type) VALUES
	(nextVal('competence_id_seq'),'Intelligence','EMPLOYE'),
	(nextVal('competence_id_seq'),'Réactivité','EMPLOYE'),
	(nextVal('competence_id_seq'),'Equilibre','EMPLOYE'),
	(nextVal('competence_id_seq'),'Endurance','EMPLOYE'),
	(nextVal('competence_id_seq'),'Adresse','EMPLOYE'),
	(nextVal('competence_id_seq'),'Sang-froid','EMPLOYE'),
	(nextVal('competence_id_seq'),'Empathie','EMPLOYE'),
	(nextVal('competence_id_seq'),'Réflexe','EMPLOYE'),
	(nextVal('competence_id_seq'),'Force','CHEVAL'),
	(nextVal('competence_id_seq'),'Endurance','CHEVAL'),
	(nextVal('competence_id_seq'),'Vitesse','CHEVAL'),
	(nextVal('competence_id_seq'),'Agilité','CHEVAL'),
	(nextVal('competence_id_seq'),'Saut','CHEVAL'),
	(nextVal('competence_id_seq'),'Concentration','CHEVAL'),
	(nextVal('competence_id_seq'),'Caractère','CHEVAL'),
	(nextVal('competence_id_seq'),'Grâce','CHEVAL'),
	(nextVal('competence_id_seq'),'Réflexe','CHEVAL');
	
--Distribuer en tout 300 point par role
INSERT INTO competence_par_role (id, role, niveau_moy, competence_id) VALUES 
	(nextVal('competence_par_role_id_seq'),'GERANT',70,1), -- Intelligence   cumul 70
	(nextVal('competence_par_role_id_seq'),'GERANT',20,2), -- Réactivité     cumul 90
	(nextVal('competence_par_role_id_seq'),'GERANT',30,3), -- Equilibre      cumul 120
	(nextVal('competence_par_role_id_seq'),'GERANT',30,4), -- Endurance      cumul 150
	(nextVal('competence_par_role_id_seq'),'GERANT',20,5), -- Adresse        cumul 170
	(nextVal('competence_par_role_id_seq'),'GERANT',60,6), -- Sang-froid     cumul 230
	(nextVal('competence_par_role_id_seq'),'GERANT',50,7), -- Empathie       cumul 280
	(nextVal('competence_par_role_id_seq'),'GERANT',20,8); -- Réflexe        cumul 300
	
