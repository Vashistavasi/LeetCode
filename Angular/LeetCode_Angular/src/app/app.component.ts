import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LeetCode_Angular';
  string1:string="this is string 1";
  string2:string="this is string 2";
  output:boolean=false;
  canConstruct(ransomNote: string, magazine: string): boolean {
    const freq: Map<string,number>=this.createMap(magazine);
    const cFreq: Map<string,number>=this.createMap(ransomNote);
    let flag:boolean=true
    cFreq.forEach((count,value)=>{
    if(freq.has(value) && freq.get(value)!>=count){
    
    }
    else {
        flag=false;
    }
    }
    );
    return true;
    };
    
 createMap(str:string): Map<string,number>{
        const freq:Map<string,number>=new Map();
        for(const char of str){
            if(freq.has(char)){
                freq.set(char,freq.get(char)!+1);
            }
            else {
                freq.set(char,1);
            }
        }
        return freq;
    }
    onclick(){
      this.output=this.canConstruct(this.string1,this.string2);
    }
}

