package com.example.practica6popcorn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class catalogo : AppCompatActivity() {

    var adapter: PeliculaAdapter? = null
    var seriesAdapter : PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()


    fun cargarPeliculas(){

        peliculas.add(Pelicula("Dune", R.drawable.demon, R.drawable.demo, "Demon Slayer: Kimetsu no Yaiba -To the Hashira Training- proyectará por primera vez en cines el episodio 11 del Arco de la Aldea de los Herreros, mostrando así la conclusión de la feroz batalla entre Tanjiro y la Cuarta Luna Creciente, Hatengu, además de cómo Nezuko logra caminar bajo el sol. Le seguirá el episodio 1 del Arco del Entrenamiento de los Pilares, donde veremos el inicio del entrenamiento de los Pilares para prepararse de cara a la próxima batalla contra Muzan Kibutsuji, que se podrá ver por primera vez.", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Dune", R.drawable.dune, R.drawable.dune2, "\"Duna: Parte Dos\" explorará el viaje mítico de Paul Atreides mientras se une con Chani y los Fremen mientras está en un camino de venganza contra los conspiradores que destruyeron a su familia. Enfrentando una elección entre el amor de su vida y el destino del universo conocido, se esfuerza por evitar un futuro terrible que solo él pueda prever.", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Ghostbusters Apocalipsis", R.drawable.ghostbusters, R.drawable.ghostbusters, "En Ghostbusters Apocalipsis Fantasma, regresa la familia Spengler a donde todo empezó – la icónica estación de bomberos en Nueva York – donde hace equipo junto con los Ghostbusters originales que han desarrollado un laboratorio de investigación ultrasecreto para llevar la cacería de fantasmas al siguiente nivel. Pero cuando el descubrimiento de un artefacto antiguo libera una fuerza maligna, los nuevos y viejos Ghostbusters unen sus fuerzas para proteger su hogar y salvar al mundo de una segunda era de hielo.", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Heroe Por Encargo", R.drawable.heroexencargo, R.drawable.heroeencargo, "Un ex agente de las fuerzas especiales acepta un trabajo para brindar seguridad a una periodista mientras entrevista a un dictador, pero estalla un golpe militar en medio de la entrevista y se ven obligados a escapar a la jungla donde deben sobrevivir.", arrayListOf<Cliente>()))
//        series.add(Pelicula("Smalville",R.drawable.adorabledemonio ,R.drawable.adorabledemonios , "La leyenda de Aang sigue al último sobreviviente de los Nómadas del Aire, quien deberá restaurar el equilibrio en el mundo entre las tres naciones restantes: la Tribu del Agua, el Reino Tierra y la Nación del Fuego.", arrayListOf<Cliente>()))
//        series.add(Pelicula("Dr. Who",R.drawable.ant ,R.drawable.ant , "Una evacuación mortal cambia la guerra del Jefe Maestro con el Covenant. En Reach, un nuevo régimen toma el mando en FLEETCOM. John siente una amenaza inminente cerca. Estreno de temporada.", arrayListOf<Cliente>()))
//        series.add(Pelicula("Bones",R.drawable.elmonstruo ,R.drawable.elmonstruovieja , "En un mundo en el que ciertos humanos llamados “cazadores” poseen habilidades mágicas, estos deben luchar contra monstruos para proteger a la raza humana de una aniquilación segura. Un cazador muy débil llamado Sung Jinwoo se encuentra en una lucha en la que solo puede tratar de sobrevivir.", arrayListOf<Cliente>()))
//        series.add(Pelicula("Dr. House",R.drawable.dune ,R.drawable.dune , "Se centra en la vida de Jung Koo Won, un temerario demonio que pierde sus poderes tras conocer a Do Do-Hee, una exitosa empresaria con la que deberá de colaborar para recuperarlos.", arrayListOf<Cliente>()))
//        series.add(Pelicula("Friends ",R.drawable.halos ,R.drawable.thewitcher , "Gyeongseong, 1945. En la oscura era colonial de Seúl, un empresario y una investigadora luchan por sobrevivir y se enfrentan a un monstruo nacido de la avaricia humana.", arrayListOf<Cliente>())))



    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        adapter = PeliculaAdapter(this,peliculas)
        seriesAdapter = PeliculaAdapter(this,series)

       var gridPelis: GridView =  findViewById(R.id.movies_catalogo)
//        var gridSeries: GridView = findViewById(R.id.series_catalogo)

        gridPelis.adapter = adapter
//        gridSeries.adapter = seriesAdapter




    }

    class PeliculaAdapter: BaseAdapter{
        var context: Context? = null
        var peliculas = ArrayList<Pelicula>()

        constructor(context: Context, peliculas: ArrayList<Pelicula>){
            this.context=context
            this.peliculas=peliculas

        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
                return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula =  peliculas[p0]
            var inflator =  context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.cell_movie, null)
            var image: ImageView = vista.findViewById(R.id.image_movie_cell)
            var title: TextView = vista.findViewById(R.id.movie_title_cell)

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            image.setOnClickListener{

                var intento = Intent(context, detalle_pelicula::class.java)
                intento.putExtra("titulo",pelicula.titulo)
                intento.putExtra("sinopsis",pelicula.sinopsis)
                intento.putExtra("header",pelicula.header)
                intento.putExtra("image",pelicula.image)
                intento.putExtra("numberSeats",(20 - pelicula.seats.size))
                context!!.startActivity(intento)

            }
            return vista

        }
    }
}