/* -------------Armurerie OlivB -----------------------------------*/

/* insert table Arme*/
Insert into ARATHIEL.ARME (IDARME,ENCOMB,MONNAIE,NOM,PRIX) values ('47','2','Cuivre','Epee','1');
Insert into ARATHIEL.ARME (IDARME,ENCOMB,MONNAIE,NOM,PRIX) values ('48','4','Cuivre','Arc','2');
Insert into ARATHIEL.ARME (IDARME,ENCOMB,MONNAIE,NOM,PRIX) values ('49','3','Argent','Dague','10');
Insert into ARATHIEL.ARME (IDARME,ENCOMB,MONNAIE,NOM,PRIX) values ('50','2','Or','Massue','15');

/*insert table joueur*/
insert into joueur values (1, 'BestPlayer');
insert into joueur values (2, 'MiddlePlayer');
insert into joueur values (3, 'BadPlayer');

/*insert table armerace*/
Insert into ARATHIEL.ARMERACE (IDARME,IDRACE) values ('46','2');
Insert into ARATHIEL.ARMERACE (IDARME,IDRACE) values ('47','1');
Insert into ARATHIEL.ARMERACE (IDARME,IDRACE) values ('47','3');

/*insert table armejoueur*/
Insert into ARATHIEL.ARMEJOUEUR (ETAT,IDARME,IDJOUEUR) values ('casse','47','3');
Insert into ARATHIEL.ARMEJOUEUR (ETAT,IDARME,IDJOUEUR) values ('neuf','47','1');
Insert into ARATHIEL.ARMEJOUEUR (ETAT,IDARME,IDJOUEUR) values ('neuf','47','2');
Insert into ARATHIEL.ARMEJOUEUR (ETAT,IDARME,IDJOUEUR) values ('usage','47','2');

commit;
