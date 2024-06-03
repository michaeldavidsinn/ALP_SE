<?php

namespace App\Http\Controllers;

use App\Models\Route;
use App\Http\Requests\StoreRouteRequest;
use App\Http\Requests\UpdateRouteRequest;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Http\Resources\UserResource;


class RouteController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

    public function getAllRoutes()
    {
        $routes = Route::all();

        foreach ($routes as $route) {
            $route->user_count = User::where('route_id', $route->id)->count();
        }

        return response()->json($routes);
    }

    public function getUserRoute()
    {
        // Dapatkan ID route untuk pengguna yang sedang login
        $routeId = Auth::user()->route_id;
    
        // Jika route_id pengguna adalah null, kembalikan rute dummy kosong
        if (!$routeId) {
            $routeId = 0; // Buat objek rute kosong baru
        }
    
        // Cari route berdasarkan route_id pengguna yang sedang login
        $userRoute = Route::find($routeId);
    
        if ($userRoute) {
            // Hitung jumlah pengguna (user count) yang terkait dengan route ini
            $userCount = User::where('route_id', $userRoute->id)->count();
            
            // Tambahkan user count ke dalam objek route
            $userRoute->user_count = $userCount;
    
            return $userRoute;
        } else {
            return null;
        }
    }
    
    

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(StoreRouteRequest $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(Route $route)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Route $route)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateRouteRequest $request, Route $route)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Route $route)
    {
        //
    }
}
