package com.example.lab2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 **********************************************************
 * REALISE PAR : Mouad Charraj aka Z3R0-XR7
 * MODULE      : Interface de Calcul Lab2
 **********************************************************
 */
public class MainActivity extends AppCompatActivity {

    // Composants de l'interface utilisateur signés par Mouad
    private EditText inputSurface_mouad;
    private EditText inputPieces_mouad;
    private CheckBox checkPiscine_mouad;
    private TextView txtResultat_mouad;
    private Button btnCalculer_mouad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialisation de la vue (Code source unique de Mouad Charraj)
        setContentView(R.layout.activity_main);

        // Liaison des vues avec les IDs personnalisés
        mouad_binding_composants();

        // Définition de l'action de clic - Style Z3R0-XR7
        btnCalculer_mouad.setOnClickListener(v -> {
            try {
                mouad_traitement_calcul();
            } catch (NumberFormatException e) {
                txtResultat_mouad.setTextColor(Color.RED);
                txtResultat_mouad.setText("Format invalide ! (Mouad)");
            } catch (Exception e) {
                Toast.makeText(this, "Une erreur est survenue.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Méthode de liaison des vues développée par Mouad
     */
    private void mouad_binding_composants() {
        inputSurface_mouad = findViewById(R.id.input_surface_mouad);
        inputPieces_mouad = findViewById(R.id.input_pieces_mouad);
        checkPiscine_mouad = findViewById(R.id.check_piscine_mouad);
        txtResultat_mouad = findViewById(R.id.txt_resultat_mouad);
        btnCalculer_mouad = findViewById(R.id.btn_calculer_mouad);
    }

    /**
     * Algorithme de calcul exclusif par Mouad Charraj avec validation > 0
     */
    private void mouad_traitement_calcul() {
        // Récupération des chaînes de caractères
        String strSurface_mouad = inputSurface_mouad.getText().toString().trim();
        String strPieces_mouad = inputPieces_mouad.getText().toString().trim();

        // 1. Validation de présence (Signé Z3R0-XR7)
        if (strSurface_mouad.isEmpty() || strPieces_mouad.isEmpty()) {
            txtResultat_mouad.setTextColor(Color.RED);
            txtResultat_mouad.setText(R.string.error_empty_fields);
            return;
        }

        // Conversion vers les types numériques requis
        double valSurface_mouad = Double.parseDouble(strSurface_mouad);
        int nbPieces_mouad = Integer.parseInt(strPieces_mouad);
        boolean aPiscine_mouad = checkPiscine_mouad.isChecked();

        // 2. LOGIQUE DE VALIDATION STRICTE : DOIT ÊTRE SUPÉRIEUR À 0
        if (valSurface_mouad <= 0 || nbPieces_mouad <= 0) {
            txtResultat_mouad.setTextColor(Color.RED); // Rouge pour l'erreur
            txtResultat_mouad.setText(R.string.error_invalid_values);
            return;
        }

        // LOGIQUE DE CALCUL (Coefficient 2.5 par Mouad)
        double taxeBase_mouad = valSurface_mouad * 2.5;
        double taxePieces_mouad = nbPieces_mouad * 60.0;
        double taxeOption_mouad = aPiscine_mouad ? 150.0 : 0.0;
        
        double totalGlobal_mouad = taxeBase_mouad + taxePieces_mouad + taxeOption_mouad;

        // Affichage du résultat en VERT si tout est OK
        txtResultat_mouad.setTextColor(Color.parseColor("#1B5E20"));
        String messageFinal_mouad = getString(R.string.result_format, totalGlobal_mouad);
        txtResultat_mouad.setText(messageFinal_mouad);
    }
}