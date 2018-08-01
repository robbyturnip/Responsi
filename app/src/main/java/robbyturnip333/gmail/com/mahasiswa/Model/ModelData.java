package robbyturnip333.gmail.com.mahasiswa.Model;

/**
 * Created by robby on 18/07/18.
 */

public class ModelData {
    String nim, nama, prodi;

    public ModelData(){}

    public ModelData(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;

    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim= nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

}
