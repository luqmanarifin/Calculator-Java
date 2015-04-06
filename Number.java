import java.io.*;
import java.lang.*;
import java.util.*;

class Number extends MathComponent{
	// attribut
	private int _nilaiInt;
	private float _nilaiFloat;
	private boolean isFloat;
	
	// konstruktor
	public Number(){
		super("0");
	}
	public Number(String s){
		super(s);
		StringBuffer str = new StringBuffer(".");
		isFloat = s.contentEquals(str);
		if(isFloat)
			_nilaiFloat = Float.parseFloat(s);
		else{
			_nilaiInt = Integer.parseInt(s);
			_nilaiFloat = Float.parseFloat(s);
		}
	}
	
	// method
	/*public Logic isLess (Number N) {
		Logic L = new Logic(_nilaiFloat < N._nilaiFloat);
		return L;
	}
	public Logic isLessThanEqual (Number N) {
		Logic L = new Logic(_nilaiFloat <= N._nilaiFloat);
		return L;
	}
	public Logic isGreater (Number N) {
		Logic L = new Logic(_nilaiFloat > N._nilaiFloat);
		return L;
	}
	public Logic isGreaterThanEqual(Number N) {
		Logic& L = new Logic(_nilaiFloat >= N._nilaiFloat);
		return L;
	}
	public Logic isEqual (Number N) {
		Logic& L = new Logic(_nilaiFloat == N._nilaiFloat);
		return L;
	}
	public Logic isNotEqual (Number N) {
		Logic L = new Logic(_nilaiFloat != N._nilaiFloat);
		return L;
	}*/
	public Number plus (Number _N){
		this.isFloat |= _N.isFloat;
		if(!this.isFloat){
			this._nilaiInt = this._nilaiInt + _N._nilaiInt;
			this._nilaiFloat = this._nilaiFloat + _N._nilaiFloat;
		}
		else
			this._nilaiFloat = this._nilaiFloat + _N._nilaiFloat;
		return this;
	}
	public Number minus (Number _N){
		this.isFloat |= _N.isFloat;
		if(!this.isFloat){
			this._nilaiInt = this._nilaiInt - _N._nilaiInt;
			this._nilaiFloat = this._nilaiFloat - _N._nilaiFloat;
		}
		else
			this._nilaiFloat = this._nilaiFloat - _N._nilaiFloat;
		return this;
	}
	public Number kali (Number _N){
		this.isFloat |= _N.isFloat;
		if(!this.isFloat){
			this._nilaiInt = this._nilaiInt * _N._nilaiInt;
			this._nilaiFloat = this._nilaiFloat * _N._nilaiFloat;
		}
		else
			this._nilaiFloat = this._nilaiFloat * _N._nilaiFloat;
		return this;
	}
	public Number bagi (Number _N){
		this.isFloat = true;
		this._nilaiFloat = this._nilaiFloat / _N._nilaiFloat;
		return this;
	}
	public Number div (Number _N){
		this.isFloat = false;
		this._nilaiFloat = this._nilaiFloat / _N._nilaiFloat;
		this._nilaiInt = (int)_nilaiFloat;
		this._nilaiFloat =  (float)this._nilaiInt;
		return this;
	}
	public Number mod (Number _N){
		this.isFloat |= _N.isFloat;
		if(!this.isFloat){
			this._nilaiInt = this._nilaiInt + _N._nilaiInt;
			this._nilaiFloat = this._nilaiFloat + _N._nilaiFloat;
		}
		else{
			this._nilaiFloat = this._nilaiFloat + _N._nilaiFloat;
		}
		return this;
	}
	public float getNilai(){
		return _nilaiFloat;
	}
	public void setNilai(float _n){
		if(this.isFloat)
			this._nilaiFloat = _n;
		else{
			this._nilaiInt = (int)_n;
			this._nilaiFloat = _n;
		}
	}
	String toString(int n) {
		String ret;
		if(this.isFloat){
			ret = String.format("%.2f", this._nilaiFloat);
		}
		else{
			ret = Integer.toString(this._nilaiInt);
		}
		return ret;
	}
}