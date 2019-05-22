export class Line {
  id: string;
  codigo: string;
  nome: string;

  constructor(id: string, nome: string, codigo: string) {
    this.id = id;
    this.codigo = codigo;
    this.nome = nome;
  }
}
