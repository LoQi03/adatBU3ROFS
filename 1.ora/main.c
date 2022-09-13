#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define LENGTH 6
typedef struct S1 {
    int code;
    char name[30];
    char birthd[16];
    int finance;
}S1;
void FileWriter();
void FileRead();

int main()
{
    FileWriter();
    FileRead();
}
void FileWriter(){
    S1 s;
    FILE *f;
    f = fopen("binfajl3.bin", "wb");
    for (int i = 0; i < LENGTH; ++i) {
        printf("%d \n",i);
        printf("Azonosito: ");
        scanf("%d" , &s.code);
        printf("Nev: ");
        scanf("%s", s.name);
        printf("Szuletesi ido: ");
        scanf("%s", s.birthd);
        printf("Fizetes: ");
        scanf("%d", &s.finance);
        printf("");
        fwrite(&s, sizeof(S1), 1, f);
    }

    fclose(f);
}
void FileRead(){
    bool isContain = false;
    S1 s;
    S1 save;
    FILE *f;
    f = fopen("binfajl3.bin", "rb");
    while (fread(&s,sizeof(S1),1,f)!= NULL)
        printf("%d %s %s %d \n",s.code,s.name,s.birthd,s.finance);
        if(s.code == 36)
        {
            isContain=true;
            save=s;
        }
    fclose(f);

    if(isContain)
    printf("%d %s %s %d",save.code,save.name,save.birthd,save.finance);

}