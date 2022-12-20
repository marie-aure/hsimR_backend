----------------------------
-- Update data
----------------------------

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