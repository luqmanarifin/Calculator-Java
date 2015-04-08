/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.MathComponent;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author Luqman A. Siswanto
 */

public class Number extends MathComponent {
	// attribut
	private int _nilaiInt;
	private float _nilaiFloat;
	private boolean isFloat;
	private boolean isRomawi;
	
	// konstruktor
	public Number(){
		super("0");
	}
	public Number(String s){
            super(s);
            StringBuffer str = new StringBuffer(".");
            isFloat = s.contains(str);
            isRomawi = !s.matches("(\\+|-)?[0-9]+(.[0-9]+)?");
            if(!this.getIsOperator()) {
                if(isRomawi){
			_nilaiInt = toInt(s);
			_nilaiFloat = (float)_nilaiInt;
		}
		else{
			if(isFloat)
				_nilaiFloat = Float.parseFloat(s);
			else{
				_nilaiInt = Integer.parseInt(s);
				_nilaiFloat = Float.parseFloat(s);
			}
		}
            }
        }
	
	// method
	public Logic isLess (Number N) {
		Logic L = new Logic(_nilaiFloat < N._nilaiFloat);
		return L;
	}
	public Logic isLessOrEqual (Number N) {
		Logic L = new Logic(_nilaiFloat <= N._nilaiFloat);
		return L;
	}
	public Logic isGreater (Number N) {
		Logic L = new Logic(_nilaiFloat > N._nilaiFloat);
		return L;
	}
	public Logic isGreaterOrEqual(Number N) {
		Logic L = new Logic(_nilaiFloat >= N._nilaiFloat);
		return L;
	}
	public Logic isEqual (Number N) {
		Logic L = new Logic(_nilaiFloat == N._nilaiFloat);
		return L;
	}
	public Logic isNotEqual (Number N) {
		Logic L = new Logic(_nilaiFloat != N._nilaiFloat);
		return L;
	}
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
			this._nilaiInt = (((this._nilaiInt % _N._nilaiInt)+_N._nilaiInt) % _N._nilaiInt);
			this._nilaiFloat = (((this._nilaiFloat % _N._nilaiFloat)+_N._nilaiFloat) % _N._nilaiFloat);
		}
		else{
			this._nilaiFloat = (((this._nilaiFloat % _N._nilaiFloat)+_N._nilaiFloat) % _N._nilaiFloat);
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
	int toInt(String s){
            int satuan = 0;
            int puluhan = 0;
            int ratusan = 0;
            int ribuan = 0;
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == 'I'){
                        if(i<s.length() - 1){
                            if(s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V'){

                            }
                        }
                        else satuan++;
                }
                if (s.charAt(i) == 'V'){
                    if(i != 0){
                        if (s.charAt(i-1) == 'I') satuan += 4;
                        else satuan += 5;
                    }
                    else{
                        satuan += 5;
                    }
                }
                if (s.charAt(i) == 'X'){
                    if(i != 0){
                        if(s.charAt(i-1) == 'I') puluhan+=9;
                        else if(i<s.length() - 1){
                            if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'){

                            }
                        }
                        else puluhan+=10;
                    }
                    else{
                        puluhan += 10;
                    }
                }
                if (s.charAt(i) == 'L'){   
                    if(i != 0){
                        if(s.charAt(i-1) == 'X') puluhan+=40;
                        else puluhan+=50;
                    }
                    else{
                        puluhan += 50;
                    }
                }
                if (s.charAt(i) == 'C'){
                    if(i != 0){
                        if(s.charAt(i-1) == 'X') ratusan+=90;
                        else if(i<s.length() - 1){
                            if(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'){

                            }
                        }
                        else ratusan += 100;
                    }
                    else{
                        ratusan += 100;
                    }
                }
                if (s.charAt(i) == 'D'){
                    if(i != 0){
                        if(s.charAt(i-1) == 'C') ratusan += 400;
                        else ratusan += 500;
                    }
                    else{
                        ratusan += 500;
                    }
                }
                if (s.charAt(i) == 'M'){
                    if(i != 0){
                        if(s.charAt(i-1) == 'C') ribuan+=900;
                        else ribuan += 1000;
                    }
                    else{
                        ribuan += 1000;
                    }
                }
            }
            int nilai = ribuan + ratusan + puluhan + satuan;
            return nilai;
        }
  @Override
	public String toString() {
		String ret;
		if(isRomawi){
			StringBuffer strTemp = new StringBuffer("");
			char rom[] = { 'I', 'V', 'X', 'L', 'C', 'D', 'M', '#', '#'};
			int x = _nilaiInt, y, z = 1000;
			for(int i = 6; i>=0; i -= 2) {
				y = x/z;
				x %= z;
				z /= 10;
				switch(y) {
				  case 3 : strTemp.append(rom[i]);
				  case 2 : strTemp.append(rom[i]);
				  case 1 : strTemp.append(rom[i]);
						   break;
				  case 4 : strTemp.append(rom[i]);
				  case 5 : strTemp.append(rom[i+1]);
						   break;
				  case 6 : strTemp.append(rom[i+1]);
						   strTemp.append(rom[i]);
						   break;
				  case 7 : strTemp.append(rom[i+1]);
						   strTemp.append(rom[i]);
						   strTemp.append(rom[i]);
						   break;
				  case 8 : strTemp.append(rom[i+1]);
						   strTemp.append(rom[i]);
						   strTemp.append(rom[i]);
						   strTemp.append(rom[i]);
						   break;
				  case 9 : strTemp.append(rom[i]);
						   strTemp.append(rom[i+2]);
				}
			}
			ret = new String(strTemp);
		}
		else{
			if(this.isFloat){
				ret = String.format("%.2f", this._nilaiFloat);
				ret = ret.replace(",",".");
			}
			else{
				ret = Integer.toString(this._nilaiInt);
			}
		}
		return ret;
	}
}