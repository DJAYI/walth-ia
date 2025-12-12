 // ícono moderno
import { useState } from "react";

export default function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log({ username, password });
    };

    return (
        <div className="min-h-screen flex flex-col items-center justify-center px-8 py-10 bg-white">

            {/* === ICON === */}
            <div className="flex flex-col items-center gap-4 mb-8">
                <div className="w-20 h-20 flex items-center justify-center rounded-full bg-green-100">
                    
                </div>

                <h1 className="text-2xl font-semibold text-center text-gray-900">
                    Sign in to continue
                </h1>

                <p className="text-center text-gray-500 text-sm max-w-xs">
                    Please try one of the following ways to register to log in to your account.
                </p>
            </div>

            {/* === FORM === */}
            <div className="w-full max-w-md shadow-lg rounded-2xl p-8 border border-gray-100">
                
                <form onSubmit={handleSubmit} className="space-y-5">

                    <div>
                        <label className="block mb-1 font-medium text-gray-700 text-sm">
                            Email
                        </label>
                        <input
                            type="email"
                            className="w-full border border-gray-300 rounded-xl p-3 focus:outline-none focus:ring focus:ring-blue-200"
                            placeholder="your@email.com"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                    </div>

                    <div>
                        <label className="block mb-1 font-medium text-gray-700 text-sm">
                            Password
                        </label>
                        <input
                            type="password"
                            className="w-full border border-gray-300 rounded-xl p-3 focus:outline-none focus:ring focus:ring-blue-200"
                            placeholder="••••••••"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>

                    <button
                        type="submit"
                        className="w-full bg-blue-500 text-white p-3 rounded-xl font-semibold hover:bg-blue-600 transition"
                    >
                        Sign in
                    </button>
                </form>

                <p className="text-center mt-5 text-sm text-gray-600">
                    Don't have an account?{" "}
                    <a href="#" className="text-blue-600 font-semibold">
                        Register
                    </a>
                </p>
            </div>
        </div>
    );
}
