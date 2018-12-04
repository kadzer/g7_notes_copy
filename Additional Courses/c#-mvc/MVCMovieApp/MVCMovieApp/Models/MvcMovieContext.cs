using System;
using Microsoft.EntityFrameworkCore;
namespace MVCMovieApp.Models
{
    public class MvcMovieContext : DbContext
    {
        public MvcMovieContext(DbContextOptions<MvcMovieContext> options) :base(options)
        {

        }

        public DbSet<MVCMovieApp.Models.Movie> Movies { get; set; }
    }
}
