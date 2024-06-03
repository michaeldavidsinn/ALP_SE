<?php

namespace App\Http\Middleware;

use Closure;
use App\Models\Comment;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Symfony\Component\HttpFoundation\Response;

class CommentWriter
{
    /**
     * Handle an incoming request.
     *
     * @param  \Closure(\Illuminate\Http\Request): (\Symfony\Component\HttpFoundation\Response)  $next
     */
    public function handle(Request $request, Closure $next): Response
    {

        $currentUser = Auth::user();
        $comment = Comment::findOrFail($request->id);
            if ($comment->user_id != $currentUser->id) {
                return response()->json([
                    'status' => Response::HTTP_UNAUTHORIZED,
                    'message' => "You are not the owner of this comment",
                    'data' => []
                ]);
            }
        return $next($request);
    }
}
