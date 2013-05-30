/*
****************************************************************************************
Compiladores 2012B
Prof. Dr. Carlos Alberto López Franco
****************************************************************************************
*/

#include <stdio.h>
#include <conio.h>
#include "arbol.h"

void main()
{
	std::locale::global(std::locale("spanish"));
	string codigo;
	//codigo= ".386 model flat ...";
	Nodo *arbol;
	arbol= arbol3();

	arbol->validaTipos();
	arbol->muestra();
	codigo= arbol->generaCodigo();
	cout << codigo << endl;
	cout << endl;
	getch();
}