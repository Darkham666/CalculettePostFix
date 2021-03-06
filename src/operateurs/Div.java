package operateurs;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.binaires.IDivision;
import calculettePostFix.ArgumentMissException;
import calculettePostFix.DivideByZeroException;

/**
 * La classe <b>Div</b> permet de faire des divisions
 * 
 * @author Thomas
 * 
 */
public class Div implements IDivision {

	/**
	 * Permet d'effectuer une division en utilisant 2 arguments issus de la pile
	 */
	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {

		Double arg1 = evaluations.retire();
		Double arg2 = evaluations.retire();

		// Verification des valeurs
		if (arg1 == 0) {
			throw new DivideByZeroException("Impossible de diviser par 0");
		}
		Double resultat = arg2 / arg1;

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		String arg1 = chaines.pop();
		String arg2 = chaines.pop();
		return "( " + arg2 + " / " + arg1 + " )";
	}

	public String toString() {
		return "/";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {

		if (elements.empty()) {
			throw new ArgumentMissException("Il manque le 1er argument");
		}
		IElement argument = elements.pop();
		argument.analyse(elements, ids);

		if (elements.empty()) {
			throw new ArgumentMissException("Il manque le 2nd argument");
		}
		argument = elements.pop();
		argument.analyse(elements, ids);
	}

}
