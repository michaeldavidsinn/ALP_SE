<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Route;

class RouteSeeder extends Seeder
{
    public function run()
    {
        Route::create([
            'destination' => 'Location A',
            'max' => 4,
            'school' => 'School A',
            'distance' => 10.5,
        ]);

        Route::create([
            'id' => 0,
            'destination' => 'null',
            'max' => 0,
            'school' => 'null',
            'distance' => 0,
        ]);

        Route::create([
            'destination' => 'Location B',
            'max' => 5,
            'school' => 'School B',
            'distance' => 5.2,
        ]);
        
        Route::create([
            'destination' => 'Location C',
            'max' => 4,
            'school' => 'School A',
            'distance' => 10.5,
        ]);

        Route::create([
            'destination' => 'Location D',
            'max' => 5,
            'school' => 'School B',
            'distance' => 5.2,
        ]);
        
        Route::create([
            'destination' => 'Location E',
            'max' => 4,
            'school' => 'School A',
            'distance' => 10.5,
        ]);

        Route::create([
            'destination' => 'Location F',
            'max' => 5,
            'school' => 'School B',
            'distance' => 5.2,
        ]);
    }
}
