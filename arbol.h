/*
*******************************************************************************
	Compiladores 2013A
	Prof. Dr. Carlos Alberto López Franco

	Modificado por:

	Macias Corral Nayeli
	Navarro Palos Carlos Eduardo
*******************************************************************************
*/

#ifndef _ARBOL
#define _ARBOL
#include <string>
#include <sstream>
#include <iostream>

/*Superclase NODO, es la contenedora de todos los tipos que acepta el 
  compilador*/
class Nodo
{
public:

	string simbolo;
	static int sangria;
	static int contadorEtiquetas;
	Nodo *sig;
	char tipoDato;

	Nodo()
	{
		sig=NULL;
	}

	void muestraSangria()
	{
		for (int i= 0; i < Nodo::sangria; i++)
		{
			printf(" ");
		}			
	}

	string siguienteEtiqueta(string contexto)
	{
		string nuevaEtiqueta = contexto + "_";
		stringstream enteroACadena;
		enteroACadena << contadorEtiquetas++;
		nuevaEtiqueta += enteroACadena.str();
		return nuevaEtiqueta;

	}
	virtual void validaTipos(){
	if (sig != NULL)
		{
			//sig->validaTipos();
			tipoDato = 'v';
		}
	
	};
	virtual void muestra(){};
	virtual string generaCodigo(){
		if (sig != NULL)
		{
			return sig->generaCodigo();
		}
		return "";
	};
};

int Nodo::sangria = 0;
int Nodo::contadorEtiquetas = 0;

/*Subclase TIPO, hijo de la clase NODO. En esta clase se crean objetos 
  que contienen el tipo de dato*/
class Tipo: public Nodo
{
public:
	//Constructor
	Tipo(string simbolo)
	{
		this->simbolo= simbolo;
	}
	//Función que muestra el sub árbol que corresponde a este nodo
	void muestra()
	{
		muestraSangria();
		cout << "<Tipo>" << simbolo << endl;
		if (sig != NULL)
		{
			sig->muestra();
		}
	}

	string generaCodigo()
	{
		string codigo;
		if(simbolo.compare("int"))
		{
			codigo += "DWORD ";
		}
		else if(simbolo.compare("float"))
		{
			codigo += "REAL4 ";
		}
		return codigo;
	}
};

/*Subclase EXPRESION, hijo de la clase NODO. En esta clase se crean objetos 
  que contienen expresiones (operaciones)*/
class Expresion: public Nodo
{
protected:

	Expresion *izq, *der;

public:

	Expresion()
	{
		izq= der= NULL;
	}

	Expresion(Expresion *izq, Expresion *der)
	{
		this->izq = izq;
		this->der = der;
		sig= NULL;
	}

	void muestra()
	{
	}

	void muestra(string op)
	{
		muestraSangria();
		cout << "<" << op << ">" << simbolo << endl;
		sangria++;
		izq->muestra();
		der->muestra();
		sangria--;
	}

	string generaCodigo()
	{
		string codigo;
		codigo = "";
		return codigo;
	}

	void validaTipos()
	{
		
	}
		
};

/*Subclase ID, hijo de la clase EXPRESION. En esta clase se crean objetos 
  que contienen identificadores*/
class ID: public Expresion
{
public:

	ID(string simbolo, ID *id=NULL)
	{
		this->simbolo= simbolo;
		sig= id;
	}

	void muestra()
	{
		muestraSangria();
		cout << "<Identificador>" << simbolo << " tipo: " << tipoDato <<  endl;
		if (sig != NULL)
		{
			sig->muestra();
		}			
	}
	void validaTipos()
	{
		//buscarTabla simbolos (simbolo) : tipo
		tipoDato = 'i';
	}

	string generaCodigo()
	{
		string codigo;
		codigo += "push " + simbolo + "\n";
		return codigo;
	}
};

/*Subclase ENTERO, hijo de la clase EXPRESION. En esta clase se crean objetos 
  que contienen numeros enteros*/
class Entero: public Expresion
{
public:

	Entero(string simbolo)
	{
		this->simbolo= simbolo;
		sig= NULL;
	}

	void muestra()
	{
		muestraSangria();
		cout << "<Entero>" << simbolo << endl;
		if (sig != NULL) 
		{
			sig->muestra();
		}
	}

	string generaCodigo()
	{
		string codigo;
		codigo += "push " + simbolo + "\n";
		return codigo;
	}

	void validaTipos()
	{
		tipoDato == 'i';

		if(sig != NULL)
		{
			sig->validaTipos();
		}
	}
};

/*Subclase REAL, hijo de la clase EXPRESION. En esta clase se crean objetos 
  que contienen numeros reales*/
class Real: public Expresion
{
public:

	Real(string simbolo)
	{
		this->simbolo= simbolo;
		sig= NULL;
	}

	void muestra()
	{
		muestraSangria();
		cout << "<Real>" << simbolo << endl;
		if (sig != NULL) 
		{
			sig->muestra();
		}
	}

	string generaCodigo()
	{
		string codigo;
		codigo = "push " + simbolo + "\n";
		return codigo;
	}

	void validaTipos()
	{
		tipoDato == 'r';

		if(sig != NULL)
		{
			sig->validaTipos();
		}
	}
};

/*Subclase SIGNO, hijo de la clase EXPRESION. En esta clase se crean objetos 
  que contienen el signo del valor (negativo - )*/
class Signo: public Expresion
{
public:

	Signo(Expresion *izq):Expresion(izq,NULL){}

	void muestra()
	{
		muestraSangria();
		cout << "<" << "Signo" << ">" << simbolo << endl;
		sangria++;
		izq->muestra();
		sangria--;
	}

	string generaCodigo()
	{
		string codigo;
        codigo += izq->generaCodigo();
        codigo += "pop eax\n";
        codigo += "mov ebx, -1\n";
        codigo += "imul ebx\n";
        codigo += "push eax\n";
		return codigo;
	}
};

/*Subclase SUMA, hijo de la clase EXPRESION. En esta clase se crean objetos 
  que contienen operaciones de suma*/
class Suma: public Expresion
{
public:

	Suma(Expresion *izq, Expresion *der):Expresion(izq,der){}

	void muestra()
	{
		Expresion::muestra("Suma");
	}

	string generaCodigo()
	{
		string codigo;
		codigo = izq->generaCodigo();
		codigo += der->generaCodigo();
		codigo += "pop ebx\n";
	    codigo += "pop eax\n";
		codigo += "add eax, ebx\n";
		codigo += "push eax\n";
		return codigo;
	}

	void validaTipos()
	{
		izq->validaTipos();
		der->validaTipos();

		if ( izq->tipoDato == 'i' && der->tipoDato == 'i')
		{
			this->tipoDato='i';
		}
		else
		{
			if ( izq->tipoDato == 'r' && der->tipoDato == 'r')
			{
				this->tipoDato='r';
			}
			else
			{
				this->tipoDato='e';
			}
		}

		if(sig != NULL)
		{
			sig->validaTipos();
		}
	}
};

/*Subclase MULTIPLICACION, hijo de la clase EXPRESION. En esta clase se crean objetos que contienen operaciones de multiplicacion*/
class Mult: public Expresion
{
public:

	Mult(Expresion *izq, Expresion *der):Expresion(izq,der){}

	void muestra()
	{
		Expresion::muestra("Mult");
	}

	string generaCodigo()
	{
		string codigo;
		codigo = izq->generaCodigo();
		codigo += der->generaCodigo();
		codigo += "pop ebx\n";
	    codigo += "pop eax\n";
		codigo += "mul ebx\n";
		codigo += "push eax\n";
		return codigo;
	}

	void validaTipos()
	{
		izq->validaTipos();
		der->validaTipos();

		if ( izq->tipoDato == 'i' && der->tipoDato == 'i')
		{
			this->tipoDato='i';
		}
		else
		{
			if ( izq->tipoDato == 'r' && der->tipoDato == 'r')
			{
				this->tipoDato='r';
			}
			else
			{
				this->tipoDato='e';
			}
		}

		if(sig != NULL)
		{
			sig->validaTipos();
		}
	}
};

/*Subclase CONJUNCION, hijo de la clase EXPRESION. En esta clase se crean objetos que contienen operaciones logicas AND*/
class Conjuncion: public Expresion
{
public:

	Conjuncion(Expresion *izq, Expresion *der):Expresion(izq,der){}

	void muestra()
	{
		Expresion::muestra("Conj");
	}

	string generaCodigo()
	{
		string etiquetaFalso = siguienteEtiqueta("AND_FALSO");
		string etiquetaFin = siguienteEtiqueta("FIN_AND");
		string codigo;
		codigo = izq->generaCodigo();
		codigo += der->generaCodigo();		
		codigo += "pop ebx\n";
		codigo += "pop eax\n";
		codigo += "cmp eax, 0\n";
		codigo += "je " + etiquetaFalso + "\n";
		codigo += "push 1\n";
		codigo += "jmp " + etiquetaFin + "\n";
		codigo += etiquetaFalso + ":" +"\n";
		codigo += "push 0\n";
		codigo += etiquetaFin + ":" +"\n";
		return codigo;
	}

	void validaTipos()
	{
		izq->validaTipos();
		der->validaTipos();

		if ( izq->tipoDato == 'i' && der->tipoDato == 'i')
		{
			this->tipoDato='i';
		}
		else
		{
			if ( izq->tipoDato == 'r' && der->tipoDato == 'r')
			{
				this->tipoDato='r';
			}
			else
			{
				this->tipoDato='e';
			}
		}

		if(sig != NULL)
		{
			sig->validaTipos();
		}
	}
};

/*Subclase CONJUNCION, hijo de la clase EXPRESION. En esta clase se crean objetos que contienen operaciones logicas OR*/
class Disyuncion: public Expresion
{
public:

	Disyuncion(Expresion *izq, Expresion *der):Expresion(izq,der){}

	void muestra()
	{
		Expresion::muestra("Disy");
	}

	string generaCodigo()
	{
		string etiquetaVerdadero = siguienteEtiqueta("OR_VERDADERO");
		string etiquetaFin = siguienteEtiqueta("FIN_OR");
		string codigo;
		codigo = izq->generaCodigo();
		codigo += der->generaCodigo();
		codigo += "pop ebx\n";
		codigo += "pop eax\n";
		codigo += "cmp eax, 0\n";
		codigo += "jne " + etiquetaVerdadero + "\n";
		codigo += "push 0\n";
		codigo += "jmp " + etiquetaFin + "\n";
		codigo += etiquetaVerdadero + ":" +"\n";
		codigo += "push 1\n";
		codigo += etiquetaFin + ":" +"\n";
		return codigo;
	}

	void validaTipos()
	{
		izq->validaTipos();
		der->validaTipos();

		if ( izq->tipoDato == 'i' && der->tipoDato == 'i')
		{
			this->tipoDato='i';
		}
		else
		{
			if ( izq->tipoDato == 'r' && der->tipoDato == 'r')
			{
				this->tipoDato='r';
			}
			else
			{
				this->tipoDato='e';
			}
		}

		if(sig != NULL)
		{
			sig->validaTipos();
		}
	}
};

class Relacional: public Expresion
{
public:

	Relacional(string simbolo, Expresion *izq, Expresion *der):Expresion(izq,der)
	{
		this->simbolo= simbolo;
	}

	void muestra()
	{
		Expresion::muestra("Relacional");
	}

	string generaCodigo()
	{
		string codigo;
		return codigo;
	}

	void validaTipos()
	{
		izq->validaTipos();
		der->validaTipos();

		if ( izq->tipoDato == 'i' && der->tipoDato == 'i')
		{
			this->tipoDato='i';
		}
		else
		{
			if ( izq->tipoDato == 'r' && der->tipoDato == 'r')
			{
				this->tipoDato='r';
			}
			else
			{
				this->tipoDato='e';
			}
		}

		if(sig != NULL)
		{
			sig->validaTipos();
		}
	}
};

class Variables: public Nodo
{
	Tipo *tipo;
	ID *identificador;

public:

	Variables(Tipo *tipo, ID *identificador, Nodo *sig=NULL)
	{
		this->tipo= tipo;
		this->identificador= identificador;
		this->sig= sig;
	}

	void muestra()
	{
		cout << "<Variables>" << endl;
		sangria++;
		tipo->muestra();
		identificador->muestra();
		sangria--;
		if (sig != NULL)
		{
			sig->muestra();
		}
	}

	string generaCodigo()
	{
		string codigo;

		if(sig != NULL)
		{
			codigo += sig->generaCodigo();
		}
		return codigo;
	}
};

class Asignacion: public Nodo
{
protected:

	ID *identificador;
	Expresion *expresion;

public:

	Asignacion(ID *identificador, Expresion *expresion, Nodo *sig=NULL)
	{
		this->identificador = identificador;
		this->expresion= expresion;
		this->sig= sig;
	}

	void muestra()
	{
		muestraSangria();
		cout << "<Asignación>" << simbolo << "tipo: " << tipoDato <<endl;
		sangria++;
		identificador->muestra();
		expresion->muestra();
		sangria--;
		if (sig != NULL)
		{
			sig->muestra();
		}
	}

	void validaTipos()
	{
		identificador->validaTipos();
		expresion->validaTipos();

		if(sig != NULL)
		{
			sig->validaTipos();
		}

	}
	string generaCodigo()
	{
		string codigo=";*************************ASIGNACION*********************\n";
		codigo += expresion->generaCodigo();
		codigo += "pop " + identificador->simbolo + "\n";
		if(sig != NULL)
		{
			codigo += sig->generaCodigo();
		}
		return codigo;
	}
};

class Si: public Nodo
{
protected:

	Expresion *expresion;
	Nodo *bloque;
	Nodo *otro;

public:

	Si(Expresion *expresion, Nodo *bloque, Nodo *otro, Nodo *sig=NULL)
	{
		this->expresion= expresion;
		this->bloque= bloque;
		this->otro= otro;
		this->sig= sig;
	}

	void muestra()
	{
		muestraSangria();
		cout << "<Si>" << endl;
		sangria++;
		expresion->muestra();
		bloque->muestra();
		if (otro != NULL)
			otro->muestra();
		sangria--;
		if (sig != NULL)
		{
			sig->muestra();
		}
	}

	string generaCodigo()
	{
		string codigo;
		return codigo;
	}
};

class Para: public Nodo
{
protected:

	Asignacion *asignacion;
	Expresion *expresionLogica;
	Asignacion *incremento;
	Nodo *bloque;

public:

	Para(Asignacion *asignacion, Expresion *expresionLogica, Asignacion *incremento, Nodo *bloque, Nodo *sig=NULL)
	{
		this->asignacion= asignacion;
		this->expresionLogica= expresionLogica;
		this->incremento= incremento;
		this->bloque= bloque;
		this->sig= sig;
	}

	void muestra()
	{
		muestraSangria();
		cout << "<Para>" << endl;
		sangria++;
		asignacion->muestra();
		expresionLogica->muestra();
		incremento->muestra();
		bloque->muestra();
		sangria--;
		if (sig != NULL)
		{
			sig->muestra();
		}
	}

	string generaCodigo()
	{
		string codigo;
		return codigo;
	}
};

class Imprime: public Nodo
{

protected:

	Expresion *expresion;

public:

	Imprime(Expresion *expresion, Nodo *sig=NULL)
	{
		this->expresion= expresion;
		this->sig= sig;
	}

	void muestra()
	{
		muestraSangria();
		cout << "<Imprime>" << endl;
		sangria++;
		expresion->muestra();
		sangria--;
		if (sig != NULL)
		{
			sig->muestra();
		}
	}

	string generaCodigo()
	{
		string codigo;
		return codigo;
	}
};

Nodo * arbol0()
{
	return new Variables( new Tipo("int"), new ID("a"));
}

Nodo *arbol1()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("b", new ID("c"))));		
}


Nodo *arbol2(){
	return new Variables( new Tipo("int"), new ID("a", new ID("b")), new Variables( new Tipo("int"), new ID("c", new ID("d")), new Asignacion( new ID("a"), new Entero( "3" ) , new Imprime( new ID("a")))));
}

Nodo *arbol3()
{	
	return new Variables( new Tipo("int"), new ID("a", new ID("b")), new Variables( new Tipo("int"), new ID("c", new ID("d")), new Asignacion( new ID("c"), new Entero( "5" ) , new Asignacion( new ID("a"), new Suma( new Entero( "3" ) , new ID("c")), new Imprime( new ID("a"), new Imprime( new Suma( new Entero( "2" ) , new Mult( new Entero( "3" ) , new Signo( new Entero( "4" ) )))))))));
}

Nodo *arbol4()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("b")), new Variables( new Tipo("int"), new ID("c", new ID("d")), new Asignacion( new ID("b"), new Entero( "2" ) , new Asignacion( new ID("c"), new Entero( "4" ) , new Asignacion( new ID("d"), new Entero( "1" ) , new Asignacion( new ID("a"), new Suma( new ID("b"), new Mult( new ID("c"), new ID("d"))), new Imprime( new ID("a"))))))));
}

Nodo *arbol5()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("z")), new Asignacion( new ID("z"), new Entero( "0" ) , new Asignacion( new ID("a"), new Entero( "5" ) , new Si( new Relacional(">", new ID("a"), new Entero( "2" ) ), new Asignacion( new ID("z"), new Entero( "1" ) ), NULL, new Imprime( new ID("z"))))));
}

Nodo *arbol6()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("z")), new Asignacion( new ID("a"), new Entero( "5" ) , new Si( new Relacional(">", new ID("a"), new Entero( "2" ) ), new Asignacion( new ID("z"), new Entero( "1" ) ), new Asignacion( new ID("z"), new Entero( "0" ) ), new Imprime( new ID("z")))));
}

Nodo *arbol7()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("b")), new Asignacion( new ID("a"), new Entero( "5" ) , new Asignacion( new ID("b"), new Entero( "10" ) , new Si( new Conjuncion( new Relacional("<=", new ID("a"), new Entero( "10" ) ), new Relacional(">=", new ID("b"), new Entero( "20" ) )), new Asignacion( new ID("z"), new Entero( "1" ) ), new Asignacion( new ID("z"), new Entero( "0" ) ), new Imprime( new ID("z"))))));
}

Nodo *arbol8()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("b", new ID("c"))), new Asignacion( new ID("a"), new Entero( "5" ) , new Asignacion( new ID("b"), new Entero( "21" ) , new Asignacion( new ID("c"), new Entero( "2" ) , new Si( new Conjuncion( new Relacional("<=", new ID("a"), new Entero( "10" ) ), new Disyuncion( new Relacional(">=", new ID("b"), new Entero( "20" ) ), new Relacional("<", new ID("c"), new Entero( "10" ) ))), new Asignacion( new ID("z"), new Entero( "1" ) ), new Asignacion( new ID("z"), new Entero( "0" ) ), new Imprime( new ID("z")))))));
}

Nodo *arbol9()
{
	return new Variables( new Tipo("int"), new ID("i"), new Para( new Asignacion( new ID("i"), new Entero( "0" ) ), new Relacional("<", new ID("i"), new Entero( "100" ) ), new Asignacion( new ID("i"), new Suma( new ID("i"), new Entero( "1" ) )), new Imprime( new ID("i"))));
}

Nodo *arbol10()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("c", new ID("i", new ID("j")))), new Asignacion( new ID("a"), new Entero( "5" ) , new Asignacion( new ID("b"), new Entero( "23" ) , new Asignacion( new ID("c"), new Entero( "6" ) , new Asignacion( new ID("j"), new Entero( "7" ) , new Si( new Conjuncion( new Relacional("<=", new ID("a"), new Entero( "10" ) ), new Disyuncion( new Relacional(">=", new ID("b"), new Entero( "20" ) ), new Relacional("!=", new ID("c"), new Entero( "30" ) ))), new Asignacion( new ID("j"), new Suma( new ID("j"), new Entero( "2" ) )), new Asignacion( new ID("j"), new Entero( "0" ) ), new Para( new Asignacion( new ID("i"), new ID("j")), new Relacional("<", new ID("i"), new Entero( "10" ) ), new Asignacion( new ID("i"), new Suma( new ID("i"), new Entero( "1" ) )), new Imprime( new ID("i")))))))));
}

Nodo *arbol0e()
{
	return new Variables( new Tipo("int"), new ID("a"), new Variables( new Tipo("float"), new ID("x"), new Asignacion( new ID("a"), new ID("x"))));
}

Nodo *arbol1e()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("b", new ID("c"))), new Asignacion( new ID("a"), new Entero( "2" ) , new Asignacion( new ID("b"), new Mult( new Entero( "3" ) , new ID("a")), new Asignacion( new ID("c"), new Suma( new ID("a"), new Mult( new ID("b"), new ID("d"))), new Imprime( new ID("c"))))));
}

Nodo *arbol2e()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("b", new ID("c"))), new Variables( new Tipo("float"), new ID("d"), new Asignacion( new ID("a"), new Suma( new Entero( "2" ) , new Mult( new Entero( "3" ) , new ID("d"))), new Imprime( new ID("a")))));
}

Nodo *arbol3e()
{
	return new Variables( new Tipo("int"), new ID("a", new ID("b", new ID("c"))), new Asignacion( new ID("b"), new Entero( "2" ) , new Asignacion( new ID("c"), new Entero( "3" ) , new Asignacion( new ID("a"), new Suma( new ID("b"), new Mult( new ID("c"), new Real( "2.5" ) )), new Imprime( new ID("a"))))));
}


#endif
